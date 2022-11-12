package com.levelup.newborn;

import com.levelup.newborn.domain.member.dto.response.MemberResponseDto;
import com.levelup.newborn.domain.member.service.MemberService;
import com.levelup.newborn.global.error.exception.EntityNotFoundException;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest extends Throwable {
    @Autowired
    MemberService memberService;

    @Test(expected = EntityNotFoundException.class)
    @DisplayName("Member Not Found Exception Test")
    public void entityNotFoundException() {

        MemberResponseDto member = memberService.getMember(Long.valueOf(2));
    }


}
