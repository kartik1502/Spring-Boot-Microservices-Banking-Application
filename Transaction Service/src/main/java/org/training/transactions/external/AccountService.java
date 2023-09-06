package org.training.transactions.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.training.transactions.configuration.FeignClientConfiguration;
import org.training.transactions.model.external.Account;
import org.training.transactions.model.response.Response;

@FeignClient(name = "account-service", configuration = FeignClientConfiguration.class)
public interface AccountService {

    @GetMapping("/accounts")
    ResponseEntity<Account> readByAccountNumber(@RequestParam String accountNumber);

    @PutMapping("/accounts")
    ResponseEntity<Response> updateAccount(@RequestParam String accountNumber, @RequestBody Account account);
}
