package org.training.core.services.service;

import org.training.core.services.model.dto.BankAccountDto;
import org.training.core.services.model.dto.UtilityAccountDto;

public interface BankAccountService {

    BankAccountDto readBankAccount(String accountNumber);
}
