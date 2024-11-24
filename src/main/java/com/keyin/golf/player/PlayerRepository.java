package com.keyin.golf.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByNameContainingIgnoreCase(String name);
    List<Player> findByPhone(String phone);
    List<Player> findByJoinDate(LocalDate joinDate);
    List<Player> findByMembershipPeriod(Integer period);
}
