package com.game.matchmaking.controller;

import com.game.matchmaking.entity.Matches;
import com.game.matchmaking.service.MatchesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
public class MatchesController {
    private final MatchesService matchesService;

    public MatchesController(MatchesService matchesService) {
        this.matchesService = matchesService;
    }

    @GetMapping
    public ResponseEntity<List<Matches>> getAllMatches() {
        return ResponseEntity.ok(matchesService.getAllMatches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matches> getMatchById(@PathVariable Integer id) {
        return ResponseEntity.ok(matchesService.getMatchById(id));
    }

    @PostMapping
    public ResponseEntity<Matches> createMatch(@RequestBody Matches match) {
        Matches created = matchesService.createMatch(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matches> updateMatch(
            @PathVariable Integer id,
            @RequestBody Matches updatedMatch) {
        return ResponseEntity.ok(matchesService.updateMatch(id, updatedMatch));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Integer id) {
        matchesService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}

