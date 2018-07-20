package com.simulevski.chessmanager.service;

import com.simulevski.chessmanager.domain.Tournament;
import com.simulevski.chessmanager.persistence.TournamentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class TournamentService {

    @Autowired
    private TournamentRepository tournamentRepository;

    public Page<Tournament> getTournamentPage(int page, int pageSize){
        return tournamentRepository.findAllByOrderByStartDesc(PageRequest.of(page,pageSize));
    }

    public int getCount(){
        return tournamentRepository.countAll();
    }

    public Tournament getById(String id) {
        Optional<Tournament> tournament = tournamentRepository.findById(id);
        return tournament.orElse(null);
    }
}
