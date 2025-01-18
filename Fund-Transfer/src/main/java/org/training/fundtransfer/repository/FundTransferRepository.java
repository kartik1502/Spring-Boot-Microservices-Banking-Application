package org.training.fundtransfer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.fundtransfer.model.entity.FundTransfer;

import java.util.List;
import java.util.Optional;

public interface FundTransferRepository extends JpaRepository<FundTransfer, Long> {

    /**
     * Finds a fund transfer by transaction reference.
     *
     * @param referenceId the transaction reference ID
     * @return an optional fund transfer object
     */
    Optional<FundTransfer> findFundTransferByTransactionReference(String referenceId);

    /**
     * Retrieves a list of FundTransfer objects based on the provided from account ID.
     *
     * @param accountId The ID of the from account.
     * @return A list of FundTransfer objects.
     */
    List<FundTransfer> findFundTransferByFromAccount(String accountId);
}
