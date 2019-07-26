package org.spring.angular.example.model.error;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse {

    private final int errorCode;
    private final String message;

}
