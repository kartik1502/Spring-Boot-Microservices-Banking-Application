package org.training.fundtransfer.service;

import org.training.fundtransfer.model.dto.FundTransferDto;
import org.training.fundtransfer.model.dto.request.FundTransferRequest;
import org.training.fundtransfer.model.dto.response.FundTransferResponse;

import java.util.List;

public interface FundTransferService {

    /**
     * Transfers funds from one account to another.
     *
     * @param fundTransferRequest The request object containing the details of the fund transfer.
     * @return The response object containing the result of the fund transfer.
     */
    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);

    /**
     * Retrieve transfer details based on the provided reference ID.
     *
     * @param referenceId The reference ID of the transfer.
     * @return The transfer details as a FundTransferDto object.
     */
    FundTransferDto getTransferDetailsFromReferenceId(String referenceId);

    /**
     * Retrieves all fund transfers associated with the given account ID.
     *
     * @param accountId the ID of the account
     * @return a list of FundTransferDto objects representing the fund transfers
     */
    List<FundTransferDto> getAllTransfersByAccountId(String accountId);
}
