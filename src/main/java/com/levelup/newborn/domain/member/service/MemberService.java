package com.levelup.newborn.domain.member.service;

import com.levelup.newborn.domain.member.dao.MemberRepository;
import com.levelup.newborn.domain.member.domain.Member;
import com.levelup.newborn.domain.member.dto.request.MemberUpdateRequestDto;
import com.levelup.newborn.domain.member.dto.request.SignUpRequestDto;
import com.levelup.newborn.domain.member.dto.response.MemberResponseDto;
import com.levelup.newborn.domain.member.dto.response.SignUpResponseDto;
import com.levelup.newborn.global.dto.ListParamDto;
import com.levelup.newborn.global.dto.PageResponseDto;
import com.levelup.newborn.global.error.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.levelup.newborn.global.error.ErrorCode.MEMBER_NOT_FOUND;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public PageResponseDto<MemberResponseDto> getMemberList(ListParamDto listParamDto) {
        Page<MemberResponseDto> memberList = memberRepository.findAll(listParamDto.getPageRequest()).map(MemberResponseDto::new);
        return new PageResponseDto<>(memberList);
    }

    public MemberResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException(MEMBER_NOT_FOUND));
        return new MemberResponseDto(member);
    }

    public SignUpResponseDto defaultSignUp(SignUpRequestDto signUpRequestDto) {
        Boolean isExistMember = memberRepository.existsByEmail(signUpRequestDto.getEmail());
        if (isExistMember) {
            throw new RuntimeException("exist Member");
        }

        //TODO: 추후 인크립트 추가
        String encryptedPassWord = signUpRequestDto.getPassword();
        Member member = signUpRequestDto.toEntity(encryptedPassWord);
        memberRepository.save(member);

        return new SignUpResponseDto(member);
    }

    public MemberResponseDto updateMember(Long memberId, MemberUpdateRequestDto memberUpdateRequestDto) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new EntityNotFoundException(MEMBER_NOT_FOUND));
        member.updateMember(memberUpdateRequestDto);
        return new MemberResponseDto(member);
    }
}
