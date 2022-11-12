package com.levelup.newborn.domain.member.dto.response;

import com.levelup.newborn.domain.member.domain.Member;
import com.levelup.newborn.domain.model.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.Valid;


@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class MemberResponseDto {
    private Long id;
    @Valid
    private Email email;
    private String nickName;
    private String username;
    private String phone;
    private String gender;
    private String profileContent;
    private String icon;
    private String photo;
    private String mbti;

    public MemberResponseDto(final Member member) {
        this.id = member.getId();
        this.email = member.getEmail();
        this.nickName = member.getNickname();
        this.username = member.getUsername();
        this.phone = member.getPhone();
        this.gender = member.getGender().toString();
        this.profileContent = member.getProfileContent();
        this.icon = member.getIcon();
        this.photo = member.getPhoto();
        this.mbti = member.getMbti();
    }

}
