package com.levelup.newborn.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode implements EnumModel {
    TEMPORARY_SERVER_ERROR("C000", "Temporary server error"),
    INVALID_CODE("C001", "Invalid Code"),
    RESOURCE_NOT_FOUND("C002", "Resource not found"),
    EXPIRED_CODE("C003", "Expired Code"),


    MEMBER_NOT_FOUND("MEM001","Member not found")
    ;


    private final String code;
    private final String message;

    @Override
    public String getKey() {
        return name();
    }

    @Override
    public String getValue() {
        return message;
    }
}
