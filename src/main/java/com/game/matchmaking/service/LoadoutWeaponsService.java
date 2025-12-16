package com.game.matchmaking.service;

import com.game.matchmaking.entity.LoadoutWeapons;
import com.game.matchmaking.exception.ResourceNotFoundException;
import com.game.matchmaking.repository.ILoadoutWeapons;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadoutWeaponsService {

    private final ILoadoutWeapons loadoutWeaponsInterface;

    public LoadoutWeaponsService(ILoadoutWeapons loadoutWeaponsInterface) {
        this.loadoutWeaponsInterface = loadoutWeaponsInterface;
    }

    public List<LoadoutWeapons> getAllLoadoutWeapons() {
        return loadoutWeaponsInterface.findAll();
    }

    public LoadoutWeapons getLoadoutWeaponById(Integer id) {
        return loadoutWeaponsInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Weapon couldn't be found in the loadout with the ID: " + id));
    }

    public LoadoutWeapons createLoadoutWeapon(LoadoutWeapons loadoutWeapon) {
        return loadoutWeaponsInterface.save(loadoutWeapon);
    }

    public LoadoutWeapons updateLoadoutWeapon(Integer id, LoadoutWeapons newData) {
        LoadoutWeapons existing = loadoutWeaponsInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Weapon couldn't be found in the loadout with the ID: " + id));

        existing.setLoadoutId(newData.getLoadoutId());
        existing.setWeaponId(newData.getWeaponId());
        existing.setSlot(newData.getSlot());

        return loadoutWeaponsInterface.save(existing);
    }

    public void deleteLoadoutWeapon(Integer id) {
        LoadoutWeapons existing = loadoutWeaponsInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Weapon couldn't be found in the loadout with the ID: " + id));

        loadoutWeaponsInterface.delete(existing);
    }
}
