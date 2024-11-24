package com.keyin.golf.competition;

import com.keyin.golf.player.Player;
import com.keyin.golf.player.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {

    @Autowired
    private CompetitionRepository competitionRepository;

    @Autowired
    private PlayerRepository playerRepository;

    public List<Competition> getAllCompetitions() {
        return competitionRepository.findAll();
    }

    public Optional<Competition> getCompetitionById(Long id) {
        return competitionRepository.findById(id);
    }

    public Competition saveCompetition(Competition competition) {
        return competitionRepository.save(competition);
    }

    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }

    // Search methods
    public List<Competition> searchByStart(LocalDate start) {
        return competitionRepository.findByStart(start);
    }

    public List<Competition> searchByVenue(String venue) {
        return competitionRepository.findByVenue(venue);
    }

    public List<Competition> searchByDateRange(LocalDate start, LocalDate end) {
        return competitionRepository.findByStartBetween(start, end);
    }

    //Player management
    public Competition addPlayerToCompetition(Long competitionId, Long playerId) {
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new RuntimeException("Competition not found"));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        competition.getParticipants().add(player);
        return competitionRepository.save(competition);
    }

    public Competition removePlayerFromCompetition(Long competitionId, Long playerId) {
        Competition competition = competitionRepository.findById(competitionId)
                .orElseThrow(() -> new RuntimeException("Competition not found"));

        competition.getParticipants().removeIf(player -> player.getId().equals(playerId));
        return competitionRepository.save(competition);
    }
}
