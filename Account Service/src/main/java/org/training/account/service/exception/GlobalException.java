package org.training.account.service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlobalException extends RuntimeException{

    private String errorCode;

    private String errorMessage;

    public GlobalException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}