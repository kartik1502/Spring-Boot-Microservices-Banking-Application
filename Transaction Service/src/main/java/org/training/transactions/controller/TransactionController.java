package org.training.transactions.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.transactions.model.dto.TransactionDto;
import org.training.transactions.model.response.Response;
import org.training.transactions.service.TransactionService;

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
}
