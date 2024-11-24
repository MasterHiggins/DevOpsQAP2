package com.keyin.golf.competition;

import com.keyin.golf.player.Player;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "competition_sequence")
    @SequenceGenerator(name = "competition_sequence", sequenceName = "competition_sequence", allocationSize = 1)
    private Long id;

    private LocalDate start;
    private LocalDate end;
    private String venue;
    private Double entryCost;
    private Double prizeMoney;

    @ManyToMany
    @JoinTable(
            name = "competition_players",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private Set<Player> participants = new HashSet<>();

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Double getEntryCost() {
        return entryCost;
    }

    public void setEntryCost(Double entryCost) {
        this.entryCost = entryCost;
    }

    public Double getPrizeMoney() {
        return prizeMoney;
    }

    public void setPrizeMoney(Double prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public Set<Player> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Player> participants) {
        this.participants = participants;
    }
}
