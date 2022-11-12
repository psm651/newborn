package com.levelup.newborn.domain.member.domain;

import com.levelup.newborn.domain.member.dto.request.MemberUpdateRequestDto;
import com.levelup.newborn.domain.model.Email;
import com.levelup.newborn.domain.model.Gender;
import com.levelup.newborn.domain.model.Level;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long Id;

    @Embedded
    @AttributeOverride(name = "value", column = @Column(name = "email", nullable = false, unique = true, updatable = false, length = 50))
    private Email email;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "level", nullable = false)
    @Enumerated(EnumType.STRING)
    private Level level = Level.BRONZE;

    @Column(name = "point", nullable = false)
    @ColumnDefault("0")
    private int point;

    @Column(name = "phone", nullable = true)
    private String phone;

    @Column(name = "gender", nullable = true)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "receive_alarm")
    @ColumnDefault("1")
    private boolean receiveAlarm;

    @Column(name = "use_message")
    @ColumnDefault("1")
    private boolean useMessage;

    @Column(name = "open_profile")
    private boolean openProfile;

    @Column(name = "user_cert")
    private boolean userCert;


    @Column(name = "last_login_datetime")
    private LocalDateTime lastLoginDatetime;

    @Column(name = "is_admin")
    private boolean isAdmin;

    @Column(name = "profile_content")
    private String profileContent;

    @Column(name = "icon")
    private String icon;

    @Column(name = "photo")
    private String photo;

    @Column(name = "mbti")
    private String mbti;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;

    /**
     * TODO: 추후 팔로우기능 개발
     *
     * @param username
     */
//    @Column(name = "following")
//    private following

//    @Column(name = "followed")
//    private followed
//
    @Builder
    public Member(Email email, String nickname, String password, String username, Level level, int point, String phone, Gender gender, boolean receiveAlarm, boolean useMessage, boolean openProfile, boolean userCert, LocalDateTime lastLoginDatetime, boolean isAdmin, String profileContent, String icon, String photo, String mbti) {
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.username = username;
        this.level = level;
        this.point = point;
        this.phone = phone;
        this.gender = gender;
        this.receiveAlarm = receiveAlarm;
        this.useMessage = useMessage;
        this.openProfile = openProfile;
        this.userCert = userCert;
        this.lastLoginDatetime = lastLoginDatetime;
        this.isAdmin = isAdmin;
        this.profileContent = profileContent;
        this.icon = icon;
        this.photo = photo;
        this.mbti = mbti;
    }

    public void updateMember(MemberUpdateRequestDto memberUpdateRequestDto) {
        if (!memberUpdateRequestDto.getIcon().isEmpty()) {
            this.icon = memberUpdateRequestDto.getIcon();
        }
        if (!memberUpdateRequestDto.getMbti().isEmpty()) {
            this.mbti= memberUpdateRequestDto.getMbti();
        }
        if (!memberUpdateRequestDto.getPassword().isEmpty()) {
            this.password = memberUpdateRequestDto.getPassword();
        }
        if (!memberUpdateRequestDto.getPhone().isEmpty()) {
            this.phone = memberUpdateRequestDto.getPhone();
        }
        if (!memberUpdateRequestDto.getPhoto().isEmpty()) {
            this.photo = memberUpdateRequestDto.getPhoto();
        }
        if (!memberUpdateRequestDto.getUsername().isEmpty()) {
            this.username = memberUpdateRequestDto.getUsername();
        }
        if (!memberUpdateRequestDto.getNickName().isEmpty()) {
            this.nickname = memberUpdateRequestDto.getNickName();
        }
        if (!memberUpdateRequestDto.getProfileContent().isEmpty()) {
            this.profileContent = memberUpdateRequestDto.getProfileContent();
        }
    }
}