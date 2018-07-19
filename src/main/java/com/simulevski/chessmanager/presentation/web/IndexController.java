package com.simulevski.chessmanager.presentation.web;

import com.simulevski.chessmanager.domain.Club;
import com.simulevski.chessmanager.domain.Member;
import com.simulevski.chessmanager.domain.Tournament;
import com.simulevski.chessmanager.service.MemberService;
import com.simulevski.chessmanager.service.TournamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class IndexController {

    @Autowired
    private final MemberService memberService;
    @Autowired
    private final TournamentService tournamentService;

    private final String INDEX = "index";
    private final int PAGESIZE = 17;

    @GetMapping
    public String index(Model model, Optional<Integer> page){
        int pageVal = page.isPresent() ? page.get() : 0;
        int pages = (int) Math.ceil(Double.parseDouble(Integer.valueOf(tournamentService.getCount()).toString()) / Double.parseDouble(Integer.valueOf(PAGESIZE).toString()));

        if(pageVal > pages){
            pageVal = 0;
        }

        Page<Tournament> tournaments = tournamentService.getTournamentPage(pageVal,PAGESIZE-1);

        if (pages == pageVal+1){
            pageVal--;
        }

        model.addAttribute("tournaments",tournaments);
        model.addAttribute("nextpage", pageVal + 1);
        return INDEX;
    }

}