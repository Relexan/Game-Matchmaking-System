package com.game.matchmaking.controller;

import com.game.matchmaking.entity.Players;
import com.game.matchmaking.service.PlayersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayersController {

    private final PlayersService playersService;

    public PlayersController(PlayersService playersService) {
        this.playersService = playersService;
    }

    @GetMapping
    public ResponseEntity<List<Players>> getAllPlayers() {
        return ResponseEntity.ok(playersService.getAllPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Players> getPlayerById(@PathVariable Integer id) {
        return ResponseEntity.ok(playersService.getPlayerById(id));
    }

    @PostMapping
    public ResponseEntity<Players> createPlayer(@RequestBody Players player) {
        Players created = playersService.createPlayer(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Players> updatePlayer(
            @PathVariable Integer id,
            @RequestBody Players updatedPlayer) {

        return ResponseEntity.ok(playersService.updatePlayer(id, updatedPlayer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Integer id) {
        playersService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
