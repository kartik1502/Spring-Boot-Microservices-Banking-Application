package org.training.account.service.service;

import org.training.account.service.model.dto.AccountDto;
import org.training.account.service.model.dto.AccountStatusUpdate;
import org.training.account.service.model.dto.response.Response;

public interface AccountService {

    Response createAccount(AccountDto accountDto);

    Response updateStatus(String accountNumber, AccountStatusUpdate accountUpdate);

    AccountDto readAccountByAccountNumber(String accountNumber);

    Response updateAccount(String accountNumber, AccountDto accountDto);
}
