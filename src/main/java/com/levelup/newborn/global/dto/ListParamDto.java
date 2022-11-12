package com.levelup.newborn.global.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@Getter
@Setter
public class ListParamDto {
    private Integer offset = 0;
    private Integer limit = 50;

    private Set<String> fields;
    private String search;
    private String searchTargets = "all";
    private String filters;

    private Set<String> sort;

    public void setOffset(int offset) {
        this.offset = Math.max(offset, 0);
    }

    public void setLimit(int limit) {
        this.limit = limit == 0 ? 50 : limit;
    }

    public PageRequest getPageRequest() {
        List<Sort.Order> orders = new ArrayList<>();
        if (this.sort != null) {
            for (String s : sort) {
                String target;
                Sort.Direction direction = Sort.Direction.ASC;
                if (s.charAt(0) != '-' && s.charAt(0) != '+') {
                    target = s;
                } else {
                    target = s.substring(1);
                    if (s.charAt(0) == '-') {
                        direction = Sort.Direction.DESC;
                    }
                }
                validateSortTarget(target);
                orders.add(new Sort.Order(direction, target));
            }
        }
        return PageRequest.of(offset, limit, Sort.by(orders));
    }

    private void validateSortTarget(String target) {
        List<String> validSortTargetList = Arrays.asList("createdDateTime", "updatedDateTime", "order");
        List<String> orderContainsEntityList = Arrays.asList("member");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String requestURI = request.getRequestURI();
        String entity = requestURI.substring(requestURI.lastIndexOf("/") + 1);

        if (!validSortTargetList.contains(target) || (target.equals("order") && !orderContainsEntityList.contains(entity))) {
            throw new RuntimeException();
        }
    }
}

