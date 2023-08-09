package org.training.core.services.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilityAccountDto {

    private Long utilityAccountId;

    private String accountNumber;

    private String providerName;
}
