package org.training.fundtransfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FundTransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(FundTransferApplication.class, args);
    }

}
