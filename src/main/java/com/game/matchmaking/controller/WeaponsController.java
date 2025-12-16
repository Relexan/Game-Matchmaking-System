package com.game.matchmaking.controller;

import com.game.matchmaking.entity.Weapons;
import com.game.matchmaking.service.WeaponsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/weapons")
public class WeaponsController {
    private final WeaponsService weaponsService;

    public WeaponsController(WeaponsService weaponsService) {
        this.weaponsService = weaponsService;
    }

    @GetMapping
    public ResponseEntity<List<Weapons>> getAllWeapons() {
        return ResponseEntity.ok(weaponsService.getAllWeapons());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Weapons> getWeaponById(@PathVariable Integer id) {
        return ResponseEntity.ok(weaponsService.getWeaponById(id));
    }

    @PostMapping
    public ResponseEntity<Weapons> createWeapon(@RequestBody Weapons weapon) {
        Weapons created = weaponsService.createWeapon(weapon);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Weapons> updateWeapon(
            @PathVariable Integer id,
            @RequestBody Weapons updatedWeapon) {

        return ResponseEntity.ok(weaponsService.updateWeapon(id, updatedWeapon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWeapon(@PathVariable Integer id) {
        weaponsService.deleteWeapon(id);
        return ResponseEntity.noContent().build();
    }
}

