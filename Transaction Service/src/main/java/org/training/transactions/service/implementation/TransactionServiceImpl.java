package org.training.transactions.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.training.transactions.exception.AccountStatusException;
import org.training.transactions.exception.GlobalErrorCode;
import org.training.transactions.exception.ResourceNotFound;
import org.training.transactions.external.AccountService;
import org.training.transactions.model.TransactionStatus;
import org.training.transactions.model.TransactionType;
import org.training.transactions.model.dto.TransactionDto;
import org.training.transactions.model.entity.Transaction;
import org.training.transactions.model.external.Account;
import org.training.transactions.model.mapper.TransactionMapper;
import org.training.transactions.model.response.Response;
import org.training.transactions.model.response.TransactionRequest;
import org.training.transactions.repository.TransactionRepository;
import org.training.transactions.service.TransactionService;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    private final TransactionMapper transactionMapper = new TransactionMapper();

    @Value("${spring.application.ok}")
    private String ok;

    /**
     * Adds a transaction to the system.
     *
     * @param transactionDto The transaction data transfer object.
     * @return The response object.
     * @throws ResourceNotFound If the requested account is not found.
     */
    @Override
    public Response addTransaction(TransactionDto transactionDto) {

        ResponseEntity<Account> response = accountService.readByAccountNumber(transactionDto.getAccountId());
        if (Objects.isNull(response.getBody())){
            throw new ResourceNotFound("Requested account not found on the server", GlobalErrorCode.NOT_FOUND);
        }
        Account account = response.getBody();
        if (!account.getAccountStatus().equals("APPROVED")){
            log.error("Account is inactive or closed");
            throw new AccountStatusException("account is inactive or closed");
        }
        Transaction transaction = transactionMapper.convertToEntity(transactionDto);
        if(transactionDto.getTransactionType().equals(TransactionType.DEPOSIT.toString())) {
            account.setAvailableBalance(account.getAvailableBalance().add(transactionDto.getAmount()));
        }

        transaction.setTransactionType(TransactionType.valueOf(transactionDto.getTransactionType()));
        transaction.setComments(transactionDto.getDescription());
        transaction.setStatus(TransactionStatus.COMPLETED);
        transaction.setReferenceId(UUID.randomUUID().toString());

        accountService.updateAccount(transactionDto.getAccountId(), account);
        transactionRepository.save(transaction);

        return Response.builder()
                .message("Transaction completed successfully")
                .responseCode(ok).build();
    }

    /**
     * Completes the internal transaction by updating the status of each transaction
     * and saving them to the transaction repository.
     *
     * @param transactionDtos the list of transaction DTOs to be processed
     * @return a response indicating the completion of the transaction
     */
    @Override
    public Response internalTransaction(List<TransactionDto> transactionDtos, String transactionReference) {

        // Convert the list of transaction DTOs to entities
        List<Transaction> transactions = transactionMapper.convertToEntityList(transactionDtos);

        // Update the status of each transaction to 'COMPLETED'
        transactions.forEach(transaction -> {
            transaction.setTransactionType(TransactionType.INTERNAL_TRANSFER);
            transaction.setStatus(TransactionStatus.COMPLETED);
            transaction.setReferenceId(transactionReference);
        });

        // Save all the completed transactions to the transaction repository
        transactionRepository.saveAll(transactions);

        // Return the response indicating the completion of the transaction
        return Response.builder()
                .responseCode(ok)
                .message("Transaction completed successfully").build();
    }

    /**
     * Retrieves a list of transaction requests for a given account ID.
     *
     * @param accountId the ID of the account
     * @return a list of transaction requests
     */
    @Override
    public List<TransactionRequest> getTransaction(String accountId) {

        return transactionRepository.findTransactionByAccountId(accountId)
                .stream().map(transaction -> {
                    TransactionRequest transactionRequest = new TransactionRequest();
                    BeanUtils.copyProperties(transaction, transactionRequest);
                    transactionRequest.setTransactionStatus(transaction.getStatus().toString());
                    transactionRequest.setLocalDateTime(transaction.getTransactionDate());
                    transactionRequest.setTransactionType(transaction.getTransactionType().toString());
                    return transactionRequest;
                }).collect(Collectors.toList());
    }

    /**
     * Retrieves a list of TransactionRequests based on a transaction reference.
     *
     * @param transactionReference The reference ID of the transaction
     * @return List of TransactionRequests matching the transaction reference
     */
    @Override
    public List<TransactionRequest> getTransactionByTransactionReference(String transactionReference) {

        return transactionRepository.findTransactionByReferenceId(transactionReference)
                .stream().map(transaction -> {
                    TransactionRequest transactionRequest = new TransactionRequest();
                    BeanUtils.copyProperties(transaction, transactionRequest);
                    transactionRequest.setTransactionStatus(transaction.getStatus().toString());
                    transactionRequest.setLocalDateTime(transaction.getTransactionDate());
                    transactionRequest.setTransactionType(transaction.getTransactionType().toString());
                    return transactionRequest;
                }).collect(Collectors.toList());
    }
}
