package org.training.fundtransfer.exception;

public class InsufficientBalance extends GlobalException{
    public InsufficientBalance(String errorCode, String message) {
        super(errorCode, message);
    }
}
