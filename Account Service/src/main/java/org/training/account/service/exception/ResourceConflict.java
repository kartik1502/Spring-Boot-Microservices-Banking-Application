package org.training.account.service.exception;

public class ResourceConflict extends RuntimeException{

    public ResourceConflict() {
        super("Account already exists");
    }

    public ResourceConflict(String message) {
        super(message);
    }
}
