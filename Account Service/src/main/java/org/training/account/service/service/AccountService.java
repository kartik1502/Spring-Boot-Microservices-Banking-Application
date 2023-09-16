package org.training.account.service.service;

import org.training.account.service.model.dto.AccountDto;
import org.training.account.service.model.dto.AccountStatusUpdate;
import org.training.account.service.model.dto.response.Response;
import org.training.account.service.model.response.TransactionResponse;

import java.util.List;

public interface AccountService {

    Response createAccount(AccountDto accountDto);

    Response updateStatus(String accountNumber, AccountStatusUpdate accountUpdate);

    AccountDto readAccountByAccountNumber(String accountNumber);

    Response updateAccount(String accountNumber, AccountDto accountDto);

    String getBalance(String accountNumber);

    List<TransactionResponse> getTransactionsFromAccountId(String accountId);
}
