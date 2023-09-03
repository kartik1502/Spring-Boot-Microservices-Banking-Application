package org.training.account.service.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.training.account.service.exception.ResourceConflict;
import org.training.account.service.exception.ResourceNotFound;
import org.training.account.service.external.SequenceService;
import org.training.account.service.external.UserService;
import org.training.account.service.model.AccountStatus;
import org.training.account.service.model.dto.AccountDto;
import org.training.account.service.model.dto.AccountStatusUpdate;
import org.training.account.service.model.dto.external.UserDto;
import org.training.account.service.model.dto.response.Response;
import org.training.account.service.model.entity.Account;
import org.training.account.service.model.mapper.AccountMapper;
import org.training.account.service.repository.AccountRepository;
import org.training.account.service.service.AccountService;

import java.math.BigDecimal;

import static org.training.account.service.model.Constants.ACC_PREFIX;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserService userService;
    private final AccountRepository accountRepository;
    private final SequenceService sequenceService;

    private final AccountMapper accountMapper = new AccountMapper();


    @Value("${spring.application.ok}")
    private String success;

    @Override
    public Response createAccount(AccountDto accountDto) {

        ResponseEntity<UserDto> user = userService.readUserById(accountDto.getUserId());

        accountRepository.findAccountByUserIdAndAccountType(accountDto.getUserId(), accountDto.getAccountType())
                .ifPresent(account -> {
                    log.error("Account already exists on the server");
                    throw new ResourceConflict("Account already exists on the server");
                });

        Account account = accountMapper.convertToEntity(accountDto);
        account.setAccountNumber(ACC_PREFIX + String.format("%07d",sequenceService.generateAccountNumber().getAccountNumber()));
        account.setAccountStatus(AccountStatus.PENDING);
            account.setActualBalance(account.getAvailableBalance());
        accountRepository.save(account);
        return Response.builder()
                .responseCode(success)
                .message(account.getAccountType().toString()+" Account created successfully").build();
    }

    @Override
    public Response updateStatus(String accountNumber, AccountStatusUpdate accountUpdate) {

        return accountRepository.findAccountByAccountNumber(accountNumber)
                .map(account -> {
                    account.setAccountStatus(accountUpdate.getAccountStatus());
                    accountRepository.save(account);
                    return Response.builder().message("Account updated successfully").responseCode(success).build();
                }).orElseThrow(() -> new ResourceNotFound("Account not on the server"));

    }
}
