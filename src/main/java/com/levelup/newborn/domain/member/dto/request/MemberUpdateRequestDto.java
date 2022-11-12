package com.levelup.newborn.domain.member.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberUpdateRequestDto {
//    @Size(max = 200, message = "CARD_TITLE_LENGTH")
    private String nickName;
    private String password;
    private String username;
    private String phone;
    private String profileContent;
    private String icon;
    private String photo;
    private String mbti;
}
