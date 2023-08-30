package org.training.account.service.model.dto.external;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long userId;

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    private String identificationNumber;

    private String authId;
}

