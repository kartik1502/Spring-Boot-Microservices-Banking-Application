package org.training.user.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    private String contactNumber;
}
