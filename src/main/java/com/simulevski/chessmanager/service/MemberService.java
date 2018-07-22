package com.simulevski.chessmanager.service;

import com.simulevski.chessmanager.domain.*;
import com.simulevski.chessmanager.persistence.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class MemberService {

    @Autowired
    private final MemberRepository memberRepository;

    public Page<Member> getMemberPage(int page, int pageSize){
        return memberRepository.findAll(PageRequest.of(page,pageSize));
    }

    public Member getById(String id){
        Optional<Member> member = memberRepository.findById(id);
        return member.orElse(null);
    }

}
