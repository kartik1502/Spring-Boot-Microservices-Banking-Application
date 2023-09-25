package org.training.fundtransfer.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.fundtransfer.configuration.FeignClientConfiguration;
import org.training.fundtransfer.model.dto.Transaction;
import org.training.fundtransfer.model.dto.response.Response;

import java.util.List;

@FeignClient(name = "transaction-service", configuration = FeignClientConfiguration.class)
public interface TransactionService {

    /**
     * Endpoint to make a transaction.
     *
     * @param transaction The transaction object containing the details of the transaction.
     * @return The ResponseEntity containing the response of the transaction.
     */
    @PostMapping("/transactions")
    ResponseEntity<Response> makeTransaction(@RequestBody Transaction transaction);

    /**
     * Make internal transactions.
     *
     * @param transactions         The list of transactions to be processed.
     * @param transactionReference The reference for the transaction.
     * @return The response entity containing the response.
     */
    @PostMapping("/transactions/internal")
    ResponseEntity<Response> makeInternalTransactions(@RequestBody List<Transaction> transactions,@RequestParam String transactionReference);
}
