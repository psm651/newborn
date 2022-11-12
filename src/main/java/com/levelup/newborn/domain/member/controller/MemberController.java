package com.levelup.newborn.domain.member.controller;

import com.levelup.newborn.domain.member.dto.request.MemberUpdateRequestDto;
import com.levelup.newborn.domain.member.dto.request.SignUpRequestDto;
import com.levelup.newborn.domain.member.dto.response.MemberResponseDto;
import com.levelup.newborn.domain.member.dto.response.SignUpResponseDto;
import com.levelup.newborn.domain.member.service.MemberService;
import com.levelup.newborn.global.dto.ListParamDto;
import com.levelup.newborn.global.dto.PageResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    @GetMapping()
    public PageResponseDto<MemberResponseDto> getMemberList(@ModelAttribute() ListParamDto listParamDto) {
        return memberService.getMemberList(listParamDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponseDto> getMember(@PathVariable final Long id) {
        return new ResponseEntity<>(memberService.getMember(id), HttpStatus.ACCEPTED);
    }

    @PostMapping()
    public ResponseEntity<SignUpResponseDto> createMember(@RequestBody @Valid final SignUpRequestDto signUpRequestDto) {
        return new ResponseEntity<>(memberService.defaultSignUp(signUpRequestDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemberResponseDto> updateMember(@PathVariable final Long id,
                                                          @RequestBody @Valid final MemberUpdateRequestDto memberUpdateRequestDto) {
        return new ResponseEntity<>(memberService.updateMember(id, memberUpdateRequestDto), HttpStatus.ACCEPTED);
    }
}
