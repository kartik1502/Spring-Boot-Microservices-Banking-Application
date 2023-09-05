package org.training.transactions.service;

import org.training.transactions.model.dto.TransactionDto;
import org.training.transactions.model.response.Response;

public interface TransactionService {

    Response addTransaction(TransactionDto transactionDto);
}
