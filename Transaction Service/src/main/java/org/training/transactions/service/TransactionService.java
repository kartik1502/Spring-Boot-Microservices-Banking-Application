package org.training.transactions.service;

import org.training.transactions.model.dto.TransactionDto;
import org.training.transactions.model.response.Response;
import org.training.transactions.model.response.TransactionRequest;

import java.util.List;

public interface TransactionService {

    Response addTransaction(TransactionDto transactionDto);

    Response internalTransaction(List<TransactionDto> transactionDtos, String transactionReference);

    List<TransactionRequest> getTransaction(String accountId);
}
