package org.training.account.service.service;

import org.training.account.service.model.dto.AccountDto;
import org.training.account.service.model.dto.AccountStatusUpdate;
import org.training.account.service.model.dto.response.Response;
import org.training.account.service.model.response.TransactionResponse;

import java.util.List;

public interface AccountService {

    /**
     * Creates a new account.
     *
     * @param accountDto the account information to be created
     * @return the response containing the created account
     */
    Response createAccount(AccountDto accountDto);

    /**
     * Updates the status of an account.
     *
     * @param accountNumber   The account number of the account to update.
     * @param accountUpdate   The account status update to apply.
     * @return                The response indicating the success or failure of the update.
     */
    Response updateStatus(String accountNumber, AccountStatusUpdate accountUpdate);

    /**
     * Retrieves an account by its account number.
     *
     * @param accountNumber The account number to search for.
     * @return The account DTO if found, or null if not found.
     */
    AccountDto readAccountByAccountNumber(String accountNumber);

    /**
     * Updates the account with the specified account number.
     *
     * @param accountNumber The account number of the account to be updated.
     * @param accountDto The account data to update the account with.
     * @return The response indicating the result of the update operation.
     */
    Response updateAccount(String accountNumber, AccountDto accountDto);

    /**
     * Retrieves the balance of the account with the specified account number.
     *
     * @param accountNumber The account number for which to retrieve the balance.
     * @return The balance of the account as a string.
     */
    String getBalance(String accountNumber);

    /**
     * Retrieves a list of transaction responses from the specified account ID.
     *
     * @param accountId The ID of the account to retrieve transactions from.
     * @return A list of transaction responses.
     */
    List<TransactionResponse> getTransactionsFromAccountId(String accountId);

    /**
     * Closes the account with the specified account number.
     *
     * @param accountNumber The account number of the account to be closed.
     * @return The response indicating the result of the account closure.
     */
    Response closeAccount(String accountNumber);

    /**
     * Retrieves the account information for a given user ID.
     *
     * @param userId The ID of the user
     * @return The account information as an AccountDto object
     */
    AccountDto readAccountByUserId(Long userId);
}
