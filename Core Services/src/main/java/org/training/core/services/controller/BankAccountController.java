package org.training.core.services.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.training.core.services.service.BankAccountService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank-accounts")
public class BankAccountController {

    private final BankAccountService bankAccountService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity readBankAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(bankAccountService.readBankAccount(accountNumber));
    }
}