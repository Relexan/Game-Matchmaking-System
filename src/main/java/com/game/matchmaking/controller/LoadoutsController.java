package com.game.matchmaking.controller;

import com.game.matchmaking.entity.Loadouts;
import com.game.matchmaking.service.LoadoutsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loadouts")
public class LoadoutsController {
    private final LoadoutsService loadoutsService;

    public LoadoutsController(LoadoutsService loadoutsService) {
        this.loadoutsService = loadoutsService;
    }

    @GetMapping
    public ResponseEntity<List<Loadouts>> getAllLoadouts() {
        return ResponseEntity.ok(loadoutsService.getAllLoadouts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loadouts> getLoadoutById(@PathVariable Integer id) {
        return ResponseEntity.ok(loadoutsService.getLoadoutById(id));
    }

    @PostMapping
    public ResponseEntity<Loadouts> createLoadout(@RequestBody Loadouts loadout) {
        Loadouts created = loadoutsService.createLoadout(loadout);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loadouts> updateLoadout(
            @PathVariable Integer id,
            @RequestBody Loadouts updatedLoadout) {
        return ResponseEntity.ok(loadoutsService.updateLoadout(id, updatedLoadout));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoadout(@PathVariable Integer id) {
        loadoutsService.deleteLoadout(id);
        return ResponseEntity.noContent().build();
    }
}
