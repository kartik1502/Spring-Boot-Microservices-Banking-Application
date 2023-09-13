package org.training.fundtransfer.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.fundtransfer.configuration.FeignClientConfiguration;
import org.training.fundtransfer.model.dto.Transaction;
import org.training.fundtransfer.model.dto.response.Response;

import java.util.List;

@FeignClient(name = "transaction-service", configuration = FeignClientConfiguration.class)
public interface TransactionService {

    @PostMapping("/transactions")
    ResponseEntity<Response> makeTransaction(@RequestBody Transaction transaction);

    @PostMapping("/transactions/internal")
    ResponseEntity<Response> makeInternalTransactions(@RequestBody List<Transaction> transactions,@RequestParam String transactionReference);
}
