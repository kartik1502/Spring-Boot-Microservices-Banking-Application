package org.training.account.service.model.dto;

import org.training.account.service.model.AccountStatus;
import org.training.account.service.model.AccountType;

import java.math.BigDecimal;

public class AccountDto {

    private Long accountId;

    private String accountNumber;

    private AccountType accountType;

    private AccountStatus accountStatus;

    private BigDecimal availableBalance;

    private BigDecimal actualBalance;

    private Long userId;
}
