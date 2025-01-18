package org.training.account.service.exception;

public class ResourceNotFound extends GlobalException{

    public ResourceNotFound() {
        super("Resource not found on the server", GlobalErrorCode.NOT_FOUND);
    }

    public ResourceNotFound(String message) {
        super(message, GlobalErrorCode.NOT_FOUND);
    }
}
