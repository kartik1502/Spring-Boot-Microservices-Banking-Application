package org.training.user.service.exception;

public class ResourceNotFound extends RuntimeException{

    public ResourceNotFound() {
        super("Resource not found on the server");
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
