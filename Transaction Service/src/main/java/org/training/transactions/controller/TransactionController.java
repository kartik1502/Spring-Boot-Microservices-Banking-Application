package org.training.transactions.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.transactions.model.dto.TransactionDto;
import org.training.transactions.model.response.Response;
import org.training.transactions.model.response.TransactionRequest;
import org.training.transactions.service.TransactionService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    /**
     * Add transactions to the system.
     *
     * @param transactionDto The transaction data to be added.
     * @return The response entity with the added transaction data.
     */
    @PostMapping
    public ResponseEntity<Response> addTransactions(@RequestBody TransactionDto transactionDto) {
        return new ResponseEntity<>(transactionService.addTransaction(transactionDto), HttpStatus.CREATED);
    }

    /**
     * Handles the endpoint for making internal transactions.
     *
     * @param transactionDtos       The list of transaction DTOs.
     * @param transactionReference  The transaction reference.
     * @return                      The response entity containing the response.
     */
    @PostMapping("/internal")
    public ResponseEntity<Response> makeInternalTransaction(@RequestBody List<TransactionDto> transactionDtos,@RequestParam String transactionReference) {
        return new ResponseEntity<>(transactionService.internalTransaction(transactionDtos, transactionReference), HttpStatus.CREATED);
    }

    /**
     * Retrieves a list of transactions for a given account ID.
     *
     * @param accountId The ID of the account
     * @return The list of transactions
     */
    @GetMapping
    public ResponseEntity<List<TransactionRequest>> getTransactions(@RequestParam String accountId) {
        return new ResponseEntity<>(transactionService.getTransaction(accountId), HttpStatus.OK);
    }

    /**
     * Retrieves a list of transaction requests based on the provided transaction reference ID.
     *
     * @param referenceId The transaction reference ID
     * @return A ResponseEntity object containing the list of transaction requests
     */
    @GetMapping("/{referenceId}")
    public ResponseEntity<List<TransactionRequest>> getTransactionByTransactionReference(@PathVariable String referenceId) {
        return new ResponseEntity<>(transactionService.getTransactionByTransactionReference(referenceId), HttpStatus.OK);
    }
}
