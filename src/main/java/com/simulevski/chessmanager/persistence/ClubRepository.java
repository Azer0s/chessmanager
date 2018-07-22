package com.simulevski.chessmanager.persistence;

import com.simulevski.chessmanager.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository extends JpaRepository<Club,String> {
}
