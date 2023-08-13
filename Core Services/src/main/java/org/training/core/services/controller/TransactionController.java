package org.training.core.services.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.core.services.model.dto.repuest.FundTransferRequest;
import org.training.core.services.model.dto.repuest.UtilityPaymentRequest;
import org.training.core.services.service.TransactionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/fund-transfers")
    public ResponseEntity fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        return ResponseEntity.ok(transactionService.fundTransfer(fundTransferRequest));
    }

    @PostMapping("/utility-payments")
    public ResponseEntity utilityPayment(@RequestBody UtilityPaymentRequest utilityPaymentRequest) {
        return ResponseEntity.ok(transactionService.utilityPayment(utilityPaymentRequest));
    }
}
