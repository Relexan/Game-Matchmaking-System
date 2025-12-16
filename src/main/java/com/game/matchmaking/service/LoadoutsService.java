package com.game.matchmaking.service;

import com.game.matchmaking.entity.Loadouts;
import com.game.matchmaking.exception.ResourceNotFoundException;
import com.game.matchmaking.repository.ILoadouts;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoadoutsService {

    private final ILoadouts loadoutsInterface;

    public LoadoutsService(ILoadouts loadoutsInterface) {
        this.loadoutsInterface = loadoutsInterface;
    }

    public List<Loadouts> getAllLoadouts() {
        return loadoutsInterface.findAll();
    }

    public Loadouts getLoadoutById(Integer id) {
        return loadoutsInterface.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loadout not found with ID: " + id));
    }

    public Loadouts createLoadout(Loadouts loadout) {
        return loadoutsInterface.save(loadout);
    }

    public Loadouts updateLoadout(Integer id, Loadouts newData) {
        Loadouts existing = loadoutsInterface.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loadout not found with ID: " + id));

        existing.setPlayerId(newData.getPlayerId());
        existing.setLoadoutName(newData.getLoadoutName());
        existing.setIsActive(newData.getIsActive());

        return loadoutsInterface.save(existing);
    }

    public void deleteLoadout(Integer id) {
        Loadouts existing = loadoutsInterface.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loadout not found with ID: " + id));

        loadoutsInterface.delete(existing);
    }
}
