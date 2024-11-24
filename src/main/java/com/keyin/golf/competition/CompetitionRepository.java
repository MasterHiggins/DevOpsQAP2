package com.keyin.golf.competition;

import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
    List<Competition> findByStart(LocalDate start);
    List<Competition> findByVenue(String venue);
//  List<Competition> findByVenueContainingIgnoreCase(String venue);
    List<Competition> findByStartBetween(LocalDate start, LocalDate end);
}
