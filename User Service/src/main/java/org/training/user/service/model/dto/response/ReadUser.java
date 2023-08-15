package org.training.user.service.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReadUser {

    private String firstName;

    private String lastName;

    private String emailId;

    private String contactNumber;
}
