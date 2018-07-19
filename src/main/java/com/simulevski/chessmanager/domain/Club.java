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
@Table(name = "Club")
public class Club {
    @Id
    private String id;
    private String city;
    private String country;
    private int postcode;
    private String street;
    private int streetNr;
    private String name;
    private Date foundation;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Club_has_Member",
            joinColumns = @JoinColumn(name = "clubId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "memberId", referencedColumnName = "id"))
    private List<Member> members;
    @OneToMany(mappedBy="host", cascade = CascadeType.ALL)
    private List<Tournament> tournaments;
}
