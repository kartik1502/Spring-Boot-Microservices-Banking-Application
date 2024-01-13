package org.training.account.service.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.account.service.model.dto.AccountDto;
import org.training.account.service.model.dto.AccountStatusUpdate;
import org.training.account.service.model.dto.response.Response;
import org.training.account.service.model.dto.external.TransactionResponse;
import org.training.account.service.service.AccountService;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    /**
     * Create an account using the provided accountDto
     *
     * @param accountDto The account details
     * @return The response entity with the created account and HTTP status code
     */
    @PostMapping
    public ResponseEntity<Response> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    /**
     * Update the status of an account.
     *
     * @param accountNumber       The account number of the account to update.
     * @param accountStatusUpdate The account status update containing the new status.
     * @return The response entity with the updated account status.
     */
    @PatchMapping
    public ResponseEntity<Response> updateAccountStatus(@RequestParam String accountNumber,@RequestBody AccountStatusUpdate accountStatusUpdate) {
        return ResponseEntity.ok(accountService.updateStatus(accountNumber, accountStatusUpdate));
    }

    /**
     * Retrieves an account by its account number.
     *
     * @param accountNumber The account number to search for.
     * @return The account DTO if found, or a 404 response if not found.
     */
    @GetMapping
    public ResponseEntity<AccountDto> readByAccountNumber(@RequestParam String accountNumber) {
        return ResponseEntity.ok(accountService.readAccountByAccountNumber(accountNumber));
    }

    /**
     * Updates an account with the given account number.
     *
     * @param accountNumber The account number of the account to be updated.
     * @param accountDto The updated account information.
     * @return The response entity with the updated account information.
     */
    @PutMapping
    public ResponseEntity<Response> updateAccount(@RequestParam String accountNumber, @RequestBody AccountDto accountDto) {
        return ResponseEntity.ok(accountService.updateAccount(accountNumber, accountDto));
    }

    /**
     * Retrieves the balance of the specified account.
     *
     * @param accountNumber The account number
     * @return The account balance
     */
    @GetMapping("/balance")
    public ResponseEntity<String> accountBalance(@RequestParam String accountNumber) {
        return ResponseEntity.ok(accountService.getBalance(accountNumber));
    }

    /**
     * Retrieve the list of transactions for a given account ID.
     *
     * @param accountId The ID of the account.
     * @return A ResponseEntity object containing a list of TransactionResponse objects.
     */
    @GetMapping("/{accountId}/transactions")
    public ResponseEntity<List<TransactionResponse>> getTransactionsFromAccountId(@PathVariable String accountId) {
        return ResponseEntity.ok(accountService.getTransactionsFromAccountId(accountId));
    }

    /**
     * Closes an account.
     *
     * @param accountNumber The account number of the account to be closed.
     * @return The response entity with the result of closing the account.
     */
    @PutMapping("/closure")
    public ResponseEntity<Response> closeAccount(@RequestParam String accountNumber) {
        return ResponseEntity.ok(accountService.closeAccount(accountNumber));
    }

    /**
     * Retrieves the account for a given user ID.
     *
     * @param userId the ID of the user
     * @return the account of the user
     */
    @GetMapping("/{userId}")
    public ResponseEntity<AccountDto> readAccountByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(accountService.readAccountByUserId(userId));











    }
}
