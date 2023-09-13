package org.training.fundtransfer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.fundtransfer.model.dto.request.FundTransferRequest;
import org.training.fundtransfer.model.dto.request.response.FundTransferResponse;
import org.training.fundtransfer.service.FundTransferService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fund-transfers")
public class FundTransferController {

    private final FundTransferService fundTransferService;

    @PostMapping
    public ResponseEntity<FundTransferResponse> fundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        return new ResponseEntity<>(fundTransferService.fundTransfer(fundTransferRequest), HttpStatus.CREATED);
    }
}
