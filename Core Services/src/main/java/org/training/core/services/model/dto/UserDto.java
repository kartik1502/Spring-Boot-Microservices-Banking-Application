package org.training.core.services.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private String identificationNumber;

    private List<BankAccountDto> bankAccountDtos;
}
