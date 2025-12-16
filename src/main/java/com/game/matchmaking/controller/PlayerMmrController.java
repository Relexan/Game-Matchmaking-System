package com.game.matchmaking.controller;

import com.game.matchmaking.entity.PlayerMmr;
import com.game.matchmaking.service.PlayerMmrService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/playermmr")
public class PlayerMmrController {

    private final PlayerMmrService playerMmrService;

    public PlayerMmrController(PlayerMmrService playerMmrService) {
        this.playerMmrService = playerMmrService;
    }

    @GetMapping
    public ResponseEntity<List<PlayerMmr>> getAllPlayerMmrs() {
        return ResponseEntity.ok(playerMmrService.getAllPlayerMmrs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerMmr> getPlayerMmrById(@PathVariable Integer id) {
        return ResponseEntity.ok(playerMmrService.getPlayerMmrById(id));
    }

    @PostMapping
    public ResponseEntity<PlayerMmr> createPlayerMmr(@RequestBody PlayerMmr pm) {
        PlayerMmr created = playerMmrService.createPlayerMmr(pm);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerMmr> updatePlayerMmr(
            @PathVariable Integer id,
            @RequestBody PlayerMmr updatedData) {
        return ResponseEntity.ok(playerMmrService.updatePlayerMmr(id, updatedData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerMmr(@PathVariable Integer id) {
        playerMmrService.deletePlayerMmr(id);
        return ResponseEntity.noContent().build();
    }
}
