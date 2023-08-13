package org.training.core.services.service;

import org.training.core.services.model.dto.repuest.FundTransferRequest;
import org.training.core.services.model.dto.repuest.UtilityPaymentRequest;
import org.training.core.services.model.dto.response.FundTransferResponse;
import org.training.core.services.model.dto.response.UtilityPaymentResponse;

public interface TransactionService {

    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);

    UtilityPaymentResponse utilityPayment(UtilityPaymentRequest utilityPaymentRequest);
}
