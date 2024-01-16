package org.training.account.service.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.training.account.service.exception.*;
import org.training.account.service.external.SequenceService;
import org.training.account.service.external.TransactionService;
import org.training.account.service.external.UserService;
import org.training.account.service.model.AccountStatus;
import org.training.account.service.model.AccountType;
import org.training.account.service.model.dto.AccountDto;
import org.training.account.service.model.dto.AccountStatusUpdate;
import org.training.account.service.model.dto.external.UserDto;
import org.training.account.service.model.dto.response.Response;
import org.training.account.service.model.entity.Account;
import org.training.account.service.model.mapper.AccountMapper;
import org.training.account.service.model.dto.external.TransactionResponse;
import org.training.account.service.repository.AccountRepository;
import org.training.account.service.service.AccountService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import static org.training.account.service.model.Constants.ACC_PREFIX;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserService userService;
    private final AccountRepository accountRepository;
    private final SequenceService sequenceService;
    private final TransactionService transactionService;

    private final AccountMapper accountMapper = new AccountMapper();


    @Value("${spring.application.ok}")
    private String success;

    /**
     * Creates an account based on the provided accountDto.
     *
     * @param accountDto The accountDto containing the necessary information to create an account.
     * @return The response indicating the result of the account creation.
     * @throws ResourceNotFound   If the user associated with the accountDto does not exist.
     * @throws ResourceConflict   If an account with the same userId and accountType already exists.
     */
    @Override
    public Response createAccount(AccountDto accountDto) {

        ResponseEntity<UserDto> user = userService.readUserById(accountDto.getUserId());
        if (Objects.isNull(user.getBody())) {
            throw new ResourceNotFound("user not found on the server");
        }

        accountRepository.findAccountByUserIdAndAccountType(accountDto.getUserId(), AccountType.valueOf(accountDto.getAccountType()))
                .ifPresent(account -> {
                    log.error("Account already exists on the server");
                    throw new ResourceConflict("Account already exists on the server");
                });

        Account account = accountMapper.convertToEntity(accountDto);
        account.setAccountNumber(ACC_PREFIX + String.format("%07d",sequenceService.generateAccountNumber().getAccountNumber()));
        account.setAccountStatus(AccountStatus.PENDING);
        account.setAvailableBalance(BigDecimal.valueOf(0));
        account.setAccountType(AccountType.valueOf(accountDto.getAccountType()));
        accountRepository.save(account);
        return Response.builder()
                .responseCode(success)
                .message(" Account created successfully").build();
    }

    /**
     * Updates the status of an account.
     *
     * @param accountNumber The account number of the account to update.
     * @param accountUpdate The account status update object.
     * @return The response indicating the result of the update.
     * @throws AccountStatusException   If the account is inactive or closed.
     * @throws InSufficientFunds       If the account balance is below the minimum required balance.
     * @throws ResourceNotFound        If the account could not be found.
     */
    @Override
    public Response updateStatus(String accountNumber, AccountStatusUpdate accountUpdate) {

        return accountRepository.findAccountByAccountNumber(accountNumber)
                .map(account -> {
                    if(account.getAccountStatus().equals(AccountStatus.ACTIVE)){
                        throw new AccountStatusException("Account is inactive/closed");
                    }
                    if(account.getAvailableBalance().compareTo(BigDecimal.ZERO) < 0 || account.getAvailableBalance().compareTo(BigDecimal.valueOf(1000)) < 0){
                        throw new InSufficientFunds("Minimum balance of Rs.1000 is required");
                    }
                    account.setAccountStatus(accountUpdate.getAccountStatus());
                    accountRepository.save(account);
                    return Response.builder().message("Account updated successfully").responseCode(success).build();
                }).orElseThrow(() -> new ResourceNotFound("Account not on the server"));

    }

    @Override
    public AccountDto readAccountByAccountNumber(String accountNumber) {

        return accountRepository.findAccountByAccountNumber(accountNumber)
                .map(account -> {
                    AccountDto accountDto = accountMapper.convertToDto(account);
                    accountDto.setAccountType(account.getAccountType().toString());
                    accountDto.setAccountStatus(account.getAccountStatus().toString());
                    return accountDto;
                })
                .orElseThrow(ResourceNotFound::new);
    }

    /**
     * Updates an account with the provided account number and account DTO.
     *
     * @param accountNumber The account number of the account to be updated.
     * @param accountDto    The account DTO containing the updated account information.
     * @return A response indicating the success or failure of the account update.
     * @throws AccountStatusException If the account is inactive or closed.
     * @throws ResourceNotFound      If the account is not found on the server.
     */
    @Override
    public Response updateAccount(String accountNumber, AccountDto accountDto) {

        return accountRepository.findAccountByAccountNumber(accountDto.getAccountNumber())
                .map(account -> {
                    BeanUtils.copyProperties(accountDto, account);
                    accountRepository.save(account);
                    return Response.builder()
                            .responseCode(success)
                            .message("Account updated successfully").build();
                }).orElseThrow(() -> new ResourceNotFound("Account not found on the server"));
    }

    /**
     * Retrieves the balance for a given account number.
     *
     * @param accountNumber The account number to retrieve the balance for.
     * @return The balance of the account as a string.
     * @throws ResourceNotFound if the account with the given account number is not found.
     */
    @Override
    public String getBalance(String accountNumber) {

        return accountRepository.findAccountByAccountNumber(accountNumber)
                .map(account -> account.getAvailableBalance().toString())
                .orElseThrow(ResourceNotFound::new);
    }

    /**
     * Retrieves a list of transaction responses from the given account ID.
     *
     * @param accountId The ID of the account to retrieve transactions from
     * @return A list of transaction responses
     */
    @Override
    public List<TransactionResponse> getTransactionsFromAccountId(String accountId) {

        return transactionService.getTransactionsFromAccountId(accountId);
    }

    /**
     * Closes the account with the specified account number.
     *
     * @param accountNumber The account number of the account to be closed.
     * @return A response indicating the result of the operation.
     * @throws ResourceNotFound If the account with the specified account number is not found.
     * @throws AccountClosingException If the balance of the account is not zero.
     */
    @Override
    public Response closeAccount(String accountNumber) {

        return accountRepository.findAccountByAccountNumber(accountNumber)
                .map(account -> {
                    if(BigDecimal.valueOf(Double.parseDouble(getBalance(accountNumber))).compareTo(BigDecimal.ZERO) != 0) {
                        throw new AccountClosingException("Balance should be zero");
                    }
                    account.setAccountStatus(AccountStatus.CLOSED);
                    return Response.builder()
                            .message("Account closed successfully").message(success)
                            .build();
                }).orElseThrow(ResourceNotFound::new);

    }

    /**
     * Read the account details for a given user ID.
     *
     * @param userId the ID of the user
     * @return the account details as an AccountDto object
     * @throws ResourceNotFound if no account is found for the user
     * @throws AccountStatusException if the account is inactive or closed
     */
    @Override
    public AccountDto readAccountByUserId(Long userId) {

        return accountRepository.findAccountByUserId(userId)
                .map(account ->{
                    if(!account.getAccountStatus().equals(AccountStatus.ACTIVE)){
                        throw new AccountStatusException("Account is inactive/closed");
                    }
                    AccountDto accountDto = accountMapper.convertToDto(account);
                    accountDto.setAccountStatus(account.getAccountStatus().toString());
                    accountDto.setAccountType(account.getAccountType().toString());
                    return accountDto;
                }).orElseThrow(ResourceNotFound::new);
    }
}