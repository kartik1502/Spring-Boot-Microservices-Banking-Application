package org.training.transactions.service;

import org.training.transactions.model.dto.TransactionDto;
import org.training.transactions.model.response.Response;
import org.training.transactions.model.response.TransactionRequest;

import java.util.List;

public interface TransactionService {

    /**
     * Adds a transaction.
     *
     * @param transactionDto The transaction to add.
     * @return The response indicating whether the transaction was successfully added.
     */
    Response addTransaction(TransactionDto transactionDto);

    /**
     * Process an internal transaction.
     *
     * @param transactionDtos The list of transaction DTOs to process.
     * @param transactionReference The transaction reference.
     * @return The response of the internal transaction.
     */
    Response internalTransaction(List<TransactionDto> transactionDtos, String transactionReference);

    /**
     * Retrieves a list of transaction requests for a given account ID.
     *
     * @param accountId the ID of the account
     * @return a list of transaction requests
     */
    List<TransactionRequest> getTransaction(String accountId);

    /**
     * Retrieves a list of transaction requests by transaction reference.
     *
     * @param transactionReference The transaction reference to search for.
     * @return A list of transaction requests matching the given transaction reference.
     */
    List<TransactionRequest> getTransactionByTransactionReference(String transactionReference);
}
