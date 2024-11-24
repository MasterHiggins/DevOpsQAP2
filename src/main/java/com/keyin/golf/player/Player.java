package com.keyin.golf.player;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keyin.golf.competition.Competition;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
    @SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence", allocationSize = 1)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phone;
    private LocalDate joinDate;
    private Integer membershipPeriod; //In Months

    @JsonIgnore
    @ManyToMany(mappedBy = "participants")
    private Set<Competition> competitions = new HashSet<>();

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getMembershipPeriod() {
        return membershipPeriod;
    }

    public void setMembershipPeriod(Integer membershipPeriod) {
        this.membershipPeriod = membershipPeriod;
    }

    public Set<Competition> getCompetitions() {
        return competitions;
    }

    public void setCompetitions(Set<Competition> competitions) {
        this.competitions = competitions;
    }
}
