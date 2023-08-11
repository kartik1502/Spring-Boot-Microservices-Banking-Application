package org.training.core.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.core.services.model.entities.UtilityAccount;

import java.util.List;
import java.util.Optional;

public interface UtilityAccountRepository extends JpaRepository<UtilityAccount, Long> {

    List<UtilityAccount> findUtilityAccountByProviderName(String providerName);
}
