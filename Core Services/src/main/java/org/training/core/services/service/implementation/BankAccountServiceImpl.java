package org.training.core.services.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.training.core.services.exception.ResourceNotFound;
import org.training.core.services.model.dto.BankAccountDto;
import org.training.core.services.model.entities.BankAccount;
import org.training.core.services.model.mapper.BankAccountMapper;
import org.training.core.services.repositories.BankAccountRepository;
import org.training.core.services.service.BankAccountService;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountMapper bankAccountMapper = new BankAccountMapper();

    private final BankAccountRepository bankAccountRepository;

    @Override
    public BankAccountDto readBankAccount(String accountNumber) {

        BankAccount bankAccount = bankAccountRepository.findBankAccountByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFound("Bank Account with account number:"+accountNumber+" not found on the server"));

        return bankAccountMapper.convertToDto(bankAccount);

    }
}
