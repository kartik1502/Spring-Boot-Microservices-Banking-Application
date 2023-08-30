package org.training.account.service.exception;

public class InSufficientFunds extends RuntimeException{
    public InSufficientFunds() {
        super("Insufficient funds");
    }

    public InSufficientFunds(String message) {
        super(message);
    }
}
