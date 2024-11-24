package com.keyin.golf.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        return playerService.getPlayerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        return playerService.getPlayerById(id)
                .map(existingPlayer -> {
                    player.setId(id);
                    return ResponseEntity.ok(playerService.savePlayer(player));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        if (playerService.getPlayerById(id).isPresent()) {
            playerService.deletePlayer(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    //Search endpoints
    @GetMapping("/search/name/{name}")
    public List<Player> searchByName(@PathVariable String name) {
        return playerService.searchByName(name);
    }

    @GetMapping("/search/phone/{phone}")
    public List<Player> searchByPhone(@PathVariable String phone) {
        return playerService.searchByPhone(phone);
    }

    @GetMapping("/search/joinDate")
    public List<Player> searchByJoinDate(@RequestParam LocalDate joinDate) {
        return playerService.searchByJoinDate(joinDate);
    }

    @GetMapping("/search/period/{period}")
    public List<Player> searchByMembershipPeriod(@PathVariable Integer period) {
        return playerService.searchByMembershipPeriod(period);
    }
}
