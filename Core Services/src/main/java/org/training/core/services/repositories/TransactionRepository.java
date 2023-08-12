package org.training.core.services.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.training.core.services.model.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
