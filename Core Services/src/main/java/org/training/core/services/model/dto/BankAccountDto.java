package org.training.core.services.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training.core.services.model.AccountStatus;
import org.training.core.services.model.AccountType;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountDto {

    private Long bankAccountId;

    private String accountNumber;

    private AccountType accountType;

    private AccountStatus accountStatus;

    private BigDecimal availableBalance;

    private BigDecimal actualBalance;

    private UserDto userDto;
}
