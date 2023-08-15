package org.training.user.service.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.training.user.service.model.Status;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;

    private String contactNumber;

    @Enumerated(EnumType.STRING)
    private Status status;
}
