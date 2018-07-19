package com.simulevski.chessmanager.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Tournament")
public class Tournament {
    @Id
    private String id;
    private String city;
    private String country;
    private int postcode;
    private String street;
    private int streetNr;
    private Date start;
    private Date end;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Tournament_has_Member",
            joinColumns = @JoinColumn(name = "tournamentId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "memberId", referencedColumnName = "id"))
    private List<Member> contestants;
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="host")
    private Club host;
}
