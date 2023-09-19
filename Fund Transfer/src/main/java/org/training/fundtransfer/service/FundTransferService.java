package org.training.fundtransfer.service;

import org.training.fundtransfer.model.dto.FundTransferDto;
import org.training.fundtransfer.model.dto.request.FundTransferRequest;
import org.training.fundtransfer.model.dto.response.FundTransferResponse;

import java.util.List;

public interface FundTransferService {

    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);

    FundTransferDto getTransferDetailsFromReferenceId(String referenceId);

    List<FundTransferDto> getAllTransfersByAccountId(String accountId);
}
