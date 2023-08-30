package org.training.account.service.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Set;
import java.util.stream.Collectors;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${spring.application.bad_request}")
    private String badRequest;

    @Value("${spring.application.conflict}")
    private String conflict;

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        Set<String> errors = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());
        return new ResponseEntity<>(new ErrorResponse(badRequest, errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceConflict.class)
    public ResponseEntity<Object> handleResourceConflictException(ResourceConflict ex) {
        return new ResponseEntity<>(new ErrorResponse(conflict, Set.of(ex.getLocalizedMessage())), HttpStatus.CONFLICT);
    }
}