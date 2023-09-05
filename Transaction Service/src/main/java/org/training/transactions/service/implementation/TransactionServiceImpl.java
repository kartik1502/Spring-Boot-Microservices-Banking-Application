package org.training.transactions.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.training.transactions.external.AccountService;
import org.training.transactions.model.TransactionStatus;
import org.training.transactions.model.TransactionType;
import org.training.transactions.model.dto.TransactionDto;
import org.training.transactions.model.entity.Transaction;
import org.training.transactions.model.external.Account;
import org.training.transactions.model.mapper.TransactionMapper;
import org.training.transactions.model.response.Response;
import org.training.transactions.repository.TransactionRepository;
import org.training.transactions.service.TransactionService;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;

    private final TransactionMapper transactionMapper = new TransactionMapper();

    @Value("${spring.application.ok}")
    private String ok;

    @Override
    public Response addTransaction(TransactionDto transactionDto) {

        ResponseEntity<Account> response = accountService.readByAccountNumber(transactionDto.getAccountId());
        Account account = response.getBody();

        Transaction transaction = transactionMapper.convertToEntity(transactionDto);
        if(transactionDto.getTransactionType().equals(TransactionType.DEPOSIT)) {
            account.setAvailableBalance(account.getAvailableBalance().add(transactionDto.getAmount()));
        }

        System.out.println(account);
        transaction.setComments(transactionDto.getDescription());
        transaction.setStatus(TransactionStatus.COMPLETED);
        transaction.setReferenceId(UUID.randomUUID().toString());

        ResponseEntity<Response> accountResponse = accountService.updateAccount(transactionDto.getAccountId(), account);
        System.out.println(accountResponse.getBody().getMessage());
        transactionRepository.save(transaction);

        return Response.builder()
                .message("Transaction completed successfully")
                .responseCode(ok).build();
    }
}
