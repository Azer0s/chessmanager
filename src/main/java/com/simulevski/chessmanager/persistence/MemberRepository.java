package com.simulevski.chessmanager.persistence;

import com.simulevski.chessmanager.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member,String> {
    List<Member> findByFirstNameStartsWith(String firstname);
}
