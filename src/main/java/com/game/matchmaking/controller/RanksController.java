package com.game.matchmaking.controller;

import com.game.matchmaking.entity.Ranks;
import com.game.matchmaking.service.RanksService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ranks")
public class RanksController {

    private final RanksService ranksService;

    public RanksController(RanksService ranksService) {
        this.ranksService = ranksService;
    }

    @GetMapping
    public ResponseEntity<List<Ranks>> getAllRanks() {
        return ResponseEntity.ok(ranksService.getAllRanks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ranks> getRankById(@PathVariable Integer id) {
        return ResponseEntity.ok(ranksService.getRankById(id));
    }

    @PostMapping
    public ResponseEntity<Ranks> createRank(@RequestBody Ranks rank) {
        Ranks created = ranksService.createRank(rank);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ranks> updateRank(
            @PathVariable Integer id,
            @RequestBody Ranks updatedRank) {
        return ResponseEntity.ok(ranksService.updateRank(id, updatedRank));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRank(@PathVariable Integer id) {
        ranksService.deleteRank(id);
        return ResponseEntity.noContent().build();
    }
}
