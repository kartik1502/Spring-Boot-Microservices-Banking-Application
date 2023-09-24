package org.training.account.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.account.service.model.AccountType;
import org.training.account.service.model.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findAccountByUserIdAndAccountType(Long userId, AccountType accountType);

    Optional<Account> findAccountByAccountNumber(String accountNumber);

    Optional<Account> findAccountByUserId(Long userId);
}
