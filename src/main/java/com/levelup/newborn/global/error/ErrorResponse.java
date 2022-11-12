package com.levelup.newborn.global.error;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private Error error;

    public ErrorResponse(ErrorCode errorCode) {
        this.error = new Error(errorCode);
    }

    public ErrorResponse(String code, String message) {
        this.error = new Error(code, message);
    }

    @Getter
    @AllArgsConstructor
    public class Error {
        private String code;
        private String message;

        public Error(ErrorCode errorCode) {
            this.code = errorCode.getCode();
            this.message = errorCode.getMessage();
        }
    }
}
