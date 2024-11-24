package com.keyin.golf.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }

    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }

    //Search methods
    public List<Player> searchByName(String name) {
        return playerRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Player> searchByPhone(String phone) {
        return playerRepository.findByPhone(phone);
    }

    public List<Player> searchByJoinDate(LocalDate joinDate) {
        return playerRepository.findByJoinDate(joinDate);
    }

    public List<Player> searchByMembershipPeriod(Integer period) {
        return playerRepository.findByMembershipPeriod(period);
    }
}
