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

    @PostMapping
    public ResponseEntity<Response> addTransactions(@RequestBody TransactionDto transactionDto) {
        return new ResponseEntity<>(transactionService.addTransaction(transactionDto), HttpStatus.CREATED);
    }

    @PostMapping("/internal")
    public ResponseEntity<Response> makeInternalTransaction(@RequestBody List<TransactionDto> transactionDtos,@RequestParam String transactionReference) {
        return new ResponseEntity<>(transactionService.internalTransaction(transactionDtos, transactionReference), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionRequest>> getTransactions(@RequestParam String accountId) {
        return new ResponseEntity<>(transactionService.getTransaction(accountId), HttpStatus.OK);
    }

    @GetMapping("/{referenceId}")
    public ResponseEntity<List<TransactionRequest>> getTransactionByTransactionReference(@PathVariable String referenceId) {
        return new ResponseEntity<>(transactionService.getTransactionByTransactionReference(referenceId), HttpStatus.OK);
    }
}
