package org.training.account.service.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.account.service.configuration.FeignClientConfiguration;
import org.training.account.service.model.response.TransactionResponse;

import java.util.List;

@FeignClient(name = "transaction-service", configuration = FeignClientConfiguration.class)
public interface TransactionService {

    @GetMapping("/transactions")
    List<TransactionResponse> getTransactionsFromAccountId(@RequestParam String accountId);
}
