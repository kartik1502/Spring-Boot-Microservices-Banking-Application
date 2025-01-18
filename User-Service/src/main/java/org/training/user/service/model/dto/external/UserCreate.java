package org.training.user.service.model.dto.external;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserCreate {

    private Long userId;

    private String firstName;

    private String lastName;

    private String identificationNumber;
}
