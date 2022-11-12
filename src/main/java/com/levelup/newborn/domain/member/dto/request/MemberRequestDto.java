package com.levelup.newborn.domain.member.dto.request;

import com.levelup.newborn.domain.member.domain.Member;
import com.levelup.newborn.domain.model.Email;
import com.levelup.newborn.domain.model.Gender;
import com.levelup.newborn.domain.model.Level;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor
public class MemberRequestDto {
    private Long id;
    @Valid
    private Email email;
    private String nickName;
    private String password;
    private String username;
    private String phone;
    private String gender;
    private String profileContent;
    private String icon;
    private String photo;
    private String mbti;

    public Member toEntity(String password) {
        Gender enumGender = gender.equals("male") ? Gender.MALE : Gender.FEMALE;
        return Member.builder()
                .email(email)
                .gender(enumGender)
                .icon(icon)
                .mbti(mbti)
                .nickname(nickName)
                .password(password)
                .phone(phone)
                .username(username)
                .profileContent(profileContent)
                .photo(photo)
                .level(Level.BRONZE)
                .build();
    }
}
