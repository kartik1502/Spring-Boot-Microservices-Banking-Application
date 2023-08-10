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
public class UtilityPaymentRequest {

    private Long providerId;

    private BigDecimal amount;

    private String referenceNumber;

    private String accountNumber;
}
