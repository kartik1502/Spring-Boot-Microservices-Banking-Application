package org.training.user.service.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdate {

    private String firstName;

    private String lastName;

    private String contactNo;

    private String address;

    private String gender;

    private String occupation;

    private String martialStatus;

    private String nationality;
}
