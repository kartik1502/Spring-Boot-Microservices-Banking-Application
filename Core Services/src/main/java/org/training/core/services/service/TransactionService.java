package org.training.core.services.service;

import org.training.core.services.model.dto.repuest.FundTransferRequest;
import org.training.core.services.model.dto.response.FundTransferResponse;

public interface TransactionService {

    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);
}
