package com.game.matchmaking.controller;

import com.game.matchmaking.entity.MatchPlayers;
import com.game.matchmaking.service.MatchPlayersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matchplayers")
public class MatchPlayersController {

    private final MatchPlayersService matchPlayersService;

    public MatchPlayersController(MatchPlayersService matchPlayersService) {
        this.matchPlayersService = matchPlayersService;
    }

    @GetMapping
    public ResponseEntity<List<MatchPlayers>> getAllMatchPlayers() {
        return ResponseEntity.ok(matchPlayersService.getAllMatchPlayers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchPlayers> getMatchPlayerById(@PathVariable Integer id) {
        return ResponseEntity.ok(matchPlayersService.getMatchPlayerById(id));
    }

    @PostMapping
    public ResponseEntity<MatchPlayers> createMatchPlayer(@RequestBody MatchPlayers mp) {
        MatchPlayers created = matchPlayersService.createMatchPlayer(mp);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatchPlayers> updateMatchPlayer(
            @PathVariable Integer id,
            @RequestBody MatchPlayers updatedData) {
        return ResponseEntity.ok(matchPlayersService.updateMatchPlayer(id, updatedData));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatchPlayer(@PathVariable Integer id) {
        matchPlayersService.deleteMatchPlayer(id);
        return ResponseEntity.noContent().build();
    }
}
