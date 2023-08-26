package org.training.core.services.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${spring.application.bad_request}")
    private String errorCodeBadRequest;

    @Value("${spring.application.conflict}")
    private String errorCodeConflict;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Set<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toSet());
        return new ResponseEntity<>(new ErrorResponse(errors, errorCodeBadRequest), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFound ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(Set.of(ex.getLocalizedMessage()), errorCodeBadRequest), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ErrorResponse> handleInsufficientBalanceException(InsufficientBalanceException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(Set.of(ex.getLocalizedMessage()), errorCodeBadRequest), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceConflict.class)
    public ResponseEntity<Object> handleResourceConflictException(ResourceConflict ex) {
        return new ResponseEntity<>(new ErrorResponse(Set.of(ex.getLocalizedMessage()), errorCodeConflict), HttpStatus.CONFLICT);
    }
}
