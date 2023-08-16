package org.training.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.fundtransfer.model.entity.FundTransfer;

public interface FundTransferRepository extends JpaRepository<FundTransfer, Long> {
}
