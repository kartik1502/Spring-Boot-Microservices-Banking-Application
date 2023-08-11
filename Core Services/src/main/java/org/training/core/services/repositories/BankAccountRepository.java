package org.training.core.services.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.core.services.model.entities.BankAccount;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Optional<BankAccount> findBankAccountByAccountNumber(String accountNumber);
}
