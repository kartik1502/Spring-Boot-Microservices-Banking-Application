package org.training.core.services.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.core.services.exception.InsufficientBalanceException;
import org.training.core.services.exception.ResourceNotFound;
import org.training.core.services.model.TransactionType;
import org.training.core.services.model.dto.repuest.FundTransferRequest;
import org.training.core.services.model.dto.response.FundTransferResponse;
import org.training.core.services.model.entities.BankAccount;
import org.training.core.services.model.entities.Transaction;
import org.training.core.services.model.mapper.BankAccountMapper;
import org.training.core.services.repositories.BankAccountRepository;
import org.training.core.services.repositories.TransactionRepository;
import org.training.core.services.service.TransactionService;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private BankAccountMapper bankAccountMapper = new BankAccountMapper();

    private final TransactionRepository transactionRepository;

    private final BankAccountRepository bankAccountRepository;

    @Override
    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {

        BankAccount fromAccount = bankAccountRepository.findBankAccountByAccountNumber(fundTransferRequest.getFromAccount())
                .orElseThrow(() -> new ResourceNotFound("Bank Account with account number: " + fundTransferRequest.getFromAccount() + " not found on the server."));

        BankAccount toAccount = bankAccountRepository.findBankAccountByAccountNumber(fundTransferRequest.getToAccount())
                .orElseThrow(() -> new ResourceNotFound("Bank Account with account number: " + fundTransferRequest.getToAccount() + " not found on the server."));

        validateAccount(fromAccount, fundTransferRequest.getAmount());

        return FundTransferResponse.builder()
                .transactionId(internalFundTransfer(fromAccount, toAccount, fundTransferRequest.getAmount()))
                .message("Fund transfer successful").build();
    }

    private String internalFundTransfer(BankAccount fromAccount, BankAccount toAccount, BigDecimal amount) {

        String transactionId = UUID.randomUUID().toString();

        fromAccount.setAvailableBalance(fromAccount.getAvailableBalance().subtract(amount));
        fromAccount.setActualBalance(fromAccount.getActualBalance().subtract(amount));

        toAccount.setAvailableBalance(toAccount.getAvailableBalance().add(amount));
        toAccount.setActualBalance(toAccount.getActualBalance().add(amount));

        List<BankAccount> bankAccounts = List.of(fromAccount, toAccount);

        List<Transaction> transactions = List.of(
                Transaction.builder()
                        .transactionId(transactionId)
                        .transactionType(TransactionType.FUND_TRANSFER)
                        .referenceNumber(toAccount.getAccountNumber())
                        .bankAccount(fromAccount)
                        .amount(amount.negate())
                        .build(),
                Transaction.builder()
                        .transactionId(transactionId)
                        .referenceNumber(toAccount.getAccountNumber())
                        .transactionType(TransactionType.FUND_TRANSFER)
                        .bankAccount(toAccount)
                        .amount(amount)
                        .build());

        bankAccountRepository.saveAll(bankAccounts);
        transactionRepository.saveAll(transactions);

        return transactionId;
    }

    private void validateAccount(BankAccount bankAccount, BigDecimal amount) {

        if(bankAccount.getAvailableBalance().compareTo(BigDecimal.ZERO) < 0 || bankAccount.getAvailableBalance().compareTo(amount) < 0) {
            throw new InsufficientBalanceException();
        }
    }
}
