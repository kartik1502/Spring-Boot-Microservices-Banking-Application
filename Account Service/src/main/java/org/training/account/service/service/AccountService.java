package org.training.account.service.service;

import org.training.account.service.model.dto.AccountDto;
import org.training.account.service.model.dto.response.Response;

public interface AccountService {

    Response createAccount(AccountDto accountDto);
}
