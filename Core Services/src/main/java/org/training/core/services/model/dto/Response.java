package org.training.core.services.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private String responseCode;

    private String responseMessage;
}
