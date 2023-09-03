package org.training.account.service.exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound() {
        super("Resource not found on the server");
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
