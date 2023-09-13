package org.training.fundtransfer.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalException extends RuntimeException{

    private String errorCode;

    private String message;

    public GlobalException(String message) {
        this.message = message;
    }
}
