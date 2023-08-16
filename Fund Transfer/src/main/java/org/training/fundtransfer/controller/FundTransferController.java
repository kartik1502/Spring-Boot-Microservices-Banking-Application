package org.training.fundtransfer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.fundtransfer.model.dto.request.FundTransferRequest;
import org.training.fundtransfer.service.FundTransferService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/fund-transfers")
public class FundTransferController {

    private final FundTransferService fundTransferService;

    @PostMapping
    public ResponseEntity fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        return ResponseEntity.ok(fundTransferService.fundTransfer(fundTransferRequest));
    }

    @GetMapping
    public ResponseEntity readAllTransfers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(fundTransferService.readAllTransfers(page, size));
    }
}
