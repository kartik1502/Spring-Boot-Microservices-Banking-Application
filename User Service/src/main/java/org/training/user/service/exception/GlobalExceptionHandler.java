package org.training.user.service.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Value("${spring.application.bad_request}")
    private String errorCodeBadRequest;

    @Value("${spring.application.conflict}")
    private String errorCodeConflict;

    @Value("${spring.application.not_found}")
    private String errorCodeNotFound;

    /**
     * Handles the case when a method argument is not valid.
     *
     * @param ex The MethodArgumentNotValidException that was thrown.
     * @param headers The HttpHeaders object for the response.
     * @param status The HttpStatus for the response.
     * @param request The WebRequest object for the response.
     * @return A ResponseEntity containing an ErrorResponse object with the error code and localized message, and the HTTP status code.
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        return new ResponseEntity<>(new ErrorResponse(errorCodeBadRequest, ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles global exceptions.
     *
     * @param globalException The global exception to handle.
     * @return The response entity with the error response.
     */
    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<Object> handleGlobalException(GlobalException globalException) {

        return ResponseEntity
                .badRequest()
                .body(ErrorResponse.builder()
                        .errorMessage(globalException.getMessage())
                        .errorCode(globalException.getErrorCode())
                        .build());
    }

}
