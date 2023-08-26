package org.training.core.services.exception;

public class ResourceConflict extends RuntimeException{

    public ResourceConflict() {
        super("Resource not found on the server");
    }

    public ResourceConflict(String message) {
        super(message);
    }
}
