package com.levelup.newborn.global.error.exception;

import com.levelup.newborn.global.error.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private ErrorCode errorCode;
    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomException(ErrorCode errorCode, HttpStatus httpStatus) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
    }
}
