package org.training.user.service.model.dto.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

    private String accountNumber;

    private BigDecimal actualBalance;

    private Integer id;

    private String type;

    private String status;

    private BigDecimal availableBalance;
}
