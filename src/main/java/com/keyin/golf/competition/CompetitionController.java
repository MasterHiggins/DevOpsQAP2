package com.keyin.golf.competition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    @Autowired
    private CompetitionService competitionService;

    @GetMapping
    public List<Competition> getAllCompetitions() {
        return competitionService.getAllCompetitions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable Long id) {
        return competitionService.getCompetitionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Competition createCompetition(@RequestBody Competition competition) {
        return competitionService.saveCompetition(competition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> updateCompetition(@PathVariable Long id, @RequestBody Competition competition) {
        return competitionService.getCompetitionById(id)
                .map(existingCompetition -> {
                    competition.setId(id);
                    return ResponseEntity.ok(competitionService.saveCompetition(competition));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        if (competitionService.getCompetitionById(id).isPresent()) {
            competitionService.deleteCompetition(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Search endpoints
    @GetMapping("/search/venue/{venue}")
    public List<Competition> searchByVenue(@PathVariable String venue) {
        return competitionService.searchByVenue(venue);
    }

    @GetMapping("/search/date")
    public List<Competition> searchByStart(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start) {
        return competitionService.searchByStart(start);
    }

    @GetMapping("/search/dateRange")
    public List<Competition> searchByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end) {
        return competitionService.searchByDateRange(start, end);
    }

    //Player management endpoints
    @PostMapping("/{competitionId}/players/{playerId}")
    public Competition addPlayerToCompetition(
            @PathVariable Long competitionId,
            @PathVariable Long playerId) {
        return competitionService.addPlayerToCompetition(competitionId, playerId);
    }

    @DeleteMapping("/{competitionId}/players/{playerId}")
    public Competition removePlayerFromCompetition(
            @PathVariable Long competitionId,
            @PathVariable Long playerId) {
        return competitionService.removePlayerFromCompetition(competitionId, playerId);
    }
}
