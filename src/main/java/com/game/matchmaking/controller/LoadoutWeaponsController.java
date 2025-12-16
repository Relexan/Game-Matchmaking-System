package com.game.matchmaking.controller;

import com.game.matchmaking.entity.LoadoutWeapons;
import com.game.matchmaking.service.LoadoutWeaponsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loadout_weapons")
public class LoadoutWeaponsController {
    private final LoadoutWeaponsService loadoutWeaponsService;

    public LoadoutWeaponsController(LoadoutWeaponsService loadoutWeaponsService) {
        this.loadoutWeaponsService = loadoutWeaponsService;
    }

    @GetMapping
    public ResponseEntity<List<LoadoutWeapons>> getAllLoadoutWeapons() {
        return ResponseEntity.ok(loadoutWeaponsService.getAllLoadoutWeapons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoadoutWeapons> getLoadoutWeaponById(@PathVariable Integer id) {
        return ResponseEntity.ok(loadoutWeaponsService.getLoadoutWeaponById(id));
    }

    @PostMapping
    public ResponseEntity<LoadoutWeapons> createLoadoutWeapon(@RequestBody LoadoutWeapons loadoutWeapon) {
        LoadoutWeapons created = loadoutWeaponsService.createLoadoutWeapon(loadoutWeapon);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoadoutWeapons> updateLoadoutWeapon(
            @PathVariable Integer id,
            @RequestBody LoadoutWeapons updatedLoadoutWeapon) {
        return ResponseEntity.ok(loadoutWeaponsService.updateLoadoutWeapon(id, updatedLoadoutWeapon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoadoutWeapon(@PathVariable Integer id) {
        loadoutWeaponsService.deleteLoadoutWeapon(id);
        return ResponseEntity.noContent().build();
    }
}
