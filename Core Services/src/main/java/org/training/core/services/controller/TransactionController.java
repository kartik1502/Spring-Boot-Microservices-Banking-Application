package org.training.core.services.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.core.services.model.dto.repuest.FundTransferRequest;
import org.training.core.services.service.TransactionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        return ResponseEntity.ok(transactionService.fundTransfer(fundTransferRequest));
    }
}
