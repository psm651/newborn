package com.levelup.newborn.domain.member.dao;

import com.levelup.newborn.domain.member.domain.Member;
import com.levelup.newborn.domain.model.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByEmail(Email email);

    Page<Member> findAll(Pageable pageable);
}

