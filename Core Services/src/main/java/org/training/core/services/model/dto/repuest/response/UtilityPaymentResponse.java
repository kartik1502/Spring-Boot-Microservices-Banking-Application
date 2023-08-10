package org.training.core.services.model.dto.repuest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilityPaymentResponse {

    private String message;

    private String transactionId;
}
