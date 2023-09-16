package org.training.account.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.account.service.model.dto.AccountDto;
import org.training.account.service.model.dto.AccountStatusUpdate;
import org.training.account.service.model.dto.response.Response;
import org.training.account.service.model.response.TransactionResponse;
import org.training.account.service.service.AccountService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<Response> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @PatchMapping
    public ResponseEntity<Response> updateAccountStatus(@RequestParam String accountNumber,@RequestBody AccountStatusUpdate accountStatusUpdate) {
        return ResponseEntity.ok(accountService.updateStatus(accountNumber, accountStatusUpdate));
    }

    @GetMapping
    public ResponseEntity<AccountDto> readByAccountNumber(@RequestParam String accountNumber) {
        return ResponseEntity.ok(accountService.readAccountByAccountNumber(accountNumber));
    }

    @PutMapping
    public ResponseEntity<Response> updateAccount(@RequestParam String accountNumber, @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.updateAccount(accountNumber, accountDto));
    }

    @GetMapping("/balance")
    public ResponseEntity<String> accountBalance(@RequestParam String accountNumber) {
        return ResponseEntity.ok(accountService.getBalance(accountNumber));
    }

    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<TransactionResponse>> getTransactionsFromAccountId(@PathVariable String accountId) {
        return ResponseEntity.ok(accountService.getTransactionsFromAccountId(accountId));
    }
}
