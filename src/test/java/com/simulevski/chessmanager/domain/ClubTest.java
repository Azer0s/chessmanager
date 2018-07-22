package com.simulevski.chessmanager.domain;

import lombok.var;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ClubTest {

    private String id = "1";
    private String city = "Vienna";
    private int postcode = 1150;
    private String street = "Hütteldorferstraße";
    private int streetNr = 1;
    private String name = "Vienna Chess Club";
    private Date foundation = new Date(2015,5,5);
    private List<Member> members = new ArrayList<>();
    private List<Tournament> tournaments = new ArrayList<>();

    @Test
    public void EnsureClubWorks(){
        var club = Club.builder()
                .id(id)
                .city(city)
                .postcode(postcode)
                .street(street)
                .streetNr(streetNr)
                .name(name)
                .foundation(foundation)
                .members(members)
                .tournaments(tournaments)
                .build();

        assertEquals(id,club.getId());
        assertEquals(city,club.getCity());
        assertEquals(postcode,club.getPostcode());
        assertEquals(street,club.getStreet());
        assertEquals(streetNr,club.getStreetNr());
        assertEquals(name,club.getName());
        assertEquals(foundation,club.getFoundation());
        assertEquals(members,club.getMembers());
        assertEquals(tournaments,club.getTournaments());

        String id = "2";
        String city = "Vienna";
        int postcode = 1050;
        String street = "Spengergasse";
        int streetNr = 1;
        String name = "Spengergasse Chess Club";
        Date foundation = new Date(2015,5,5);
        List<Member> members = new ArrayList<>();
        List<Tournament> tournaments = new ArrayList<>();

        club.setId(id);
        club.setCity(city);
        club.setPostcode(postcode);
        club.setStreet(street);
        club.setStreetNr(streetNr);
        club.setName(name);
        club.setFoundation(foundation);
        club.setMembers(members);
        club.setTournaments(tournaments);

        assertEquals(id,club.getId());
        assertEquals(city,club.getCity());
        assertEquals(postcode,club.getPostcode());
        assertEquals(street,club.getStreet());
        assertEquals(streetNr,club.getStreetNr());
        assertEquals(name,club.getName());
        assertEquals(foundation,club.getFoundation());
        assertEquals(members,club.getMembers());
        assertEquals(tournaments,club.getTournaments());
    }
}
