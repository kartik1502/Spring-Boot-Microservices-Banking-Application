package org.training.transactions.exception;

public class AccountStatusException extends GlobalException {

    public AccountStatusException(String message) {
        super(message, GlobalErrorCode.BAD_REQUEST);
    }
}
