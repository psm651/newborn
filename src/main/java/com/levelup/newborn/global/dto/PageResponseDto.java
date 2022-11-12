package com.levelup.newborn.global.dto;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

@Getter
public class PageResponseDto<T> implements Serializable {

    private List<T> value;
    private long count;
    private long offset;
    private long limit;
    private long total;

    @Builder
    public PageResponseDto(List<T> value, long count, long offset, long limit, long total) {
        this.value = value;
        this.count = count;
        this.offset = offset;
        this.limit = limit;
        this.total = total;
    }

    public PageResponseDto(Page<T> page) {
        this.value = page.getContent();
        this.count = page.getNumberOfElements();
        this.offset = page.getPageable().getPageNumber();
        this.limit = page.getPageable().getPageSize();
        this.total = page.getTotalElements();
    }
}
