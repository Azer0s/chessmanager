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
@Table(name = "Member")
public class Member {
    @Id
    private String id;
    private String email;
    private String phoneNum;
    private String firstName;
    private String lastName;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "title", referencedColumnName = "id", nullable = true, updatable = true)
    private Titles title;
    private Date rankingDate;
    private String nationality;
    @ManyToMany(mappedBy = "members", cascade = CascadeType.ALL)
    private List<Club> clubs;
    @ManyToMany(mappedBy = "contestants", cascade = CascadeType.ALL)
    private List<Tournament> tournaments;
}
