package org.training.transactions.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.transactions.model.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
