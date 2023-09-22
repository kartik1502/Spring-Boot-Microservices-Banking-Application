package org.training.user.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.user.service.model.external.Account;

@FeignClient(name = "account-service", configuration = FeignClientProperties.FeignClientConfiguration.class)
public interface AccountService {

    @GetMapping("/accounts")
    ResponseEntity<Account> readByAccountNumber(@RequestParam String accountNumber);
}
