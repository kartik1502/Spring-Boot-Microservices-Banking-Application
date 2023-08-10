package org.training.core.services.model.dto.repuest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FundTransferRequest {

    private String fromAccount;

    private String toAccount;

    private BigDecimal amount;
}
