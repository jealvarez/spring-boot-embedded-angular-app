package org.spring.angular.example.model.error;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ErrorResponse.Builder.class)
public class ErrorResponse {

    private final int errorCode;
    private final String message;

    private ErrorResponse(final Builder builder) {
        errorCode = builder.errorCode;
        message = builder.message;
    }

    public static Builder anErrorResponse() {
        return new Builder();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    @JsonPOJOBuilder
    public static final class Builder {

        private int errorCode;
        private String message;

        private Builder() {
        }

        public Builder withErrorCode(final int val) {
            errorCode = val;
            return this;
        }

        public Builder withMessage(final String val) {
            message = val;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }

    }

}
