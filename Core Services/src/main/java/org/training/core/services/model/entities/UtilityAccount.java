package org.training.core.services.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UtilityAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UtilityAccountId;

    private String accountNumber;

    private String providerName;
}
