package com.game.matchmaking.service;

import com.game.matchmaking.entity.Weapons;
import com.game.matchmaking.exception.ResourceNotFoundException;
import com.game.matchmaking.repository.IWeapons;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponsService {

    private final IWeapons weaponsInterface;

    public WeaponsService(IWeapons weaponsInterface) {
        this.weaponsInterface = weaponsInterface;
    }

    public List<Weapons> getAllWeapons() {
        return weaponsInterface.findAll();
    }

    public Weapons getWeaponById(Integer id) {
        return weaponsInterface.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Weapon couldn't found with the entered ID: " + id));
    }

    public Weapons createWeapon(Weapons weapon) {
        return weaponsInterface.save(weapon);
    }

    public Weapons updateWeapon(Integer id, Weapons newData) {
        Weapons existing = weaponsInterface.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Weapon couldn't found with the entered ID: " + id));

        existing.setWeaponName(newData.getWeaponName());
        existing.setWeaponType(newData.getWeaponType());
        existing.setDamage(newData.getDamage());
        existing.setSpeed(newData.getSpeed());

        return weaponsInterface.save(existing);
    }

    public void deleteWeapon(Integer id) {
        Weapons existing = weaponsInterface.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Weapon couldn't found with the entered ID: " + id));

        weaponsInterface.delete(existing);
    }
}

