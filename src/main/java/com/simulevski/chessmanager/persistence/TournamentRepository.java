package com.simulevski.chessmanager.persistence;

import com.simulevski.chessmanager.domain.Tournament;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament,String> {
    @Query(value = "SELECT COUNT(*) FROM Tournament", nativeQuery = true)
    int countAll();
    Page<Tournament> findAllByOrderByStartDesc(Pageable pageable);
}
