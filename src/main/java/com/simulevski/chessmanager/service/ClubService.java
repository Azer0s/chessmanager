package com.simulevski.chessmanager.service;

import com.simulevski.chessmanager.domain.Club;
import com.simulevski.chessmanager.persistence.ClubRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public Club getById(String id){
        Optional<Club> club = clubRepository.findById(id);
        return club.orElse(null);
    }
}
