package com.game.matchmaking.service;

import com.game.matchmaking.entity.PlayerMmr;
import com.game.matchmaking.exception.ResourceNotFoundException;
import com.game.matchmaking.repository.IPlayerMmr;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerMmrService {

    private final IPlayerMmr playerMmrInterface;

    public PlayerMmrService(IPlayerMmr playerMmrInterface) {
        this.playerMmrInterface = playerMmrInterface;
    }

    public List<PlayerMmr> getAllPlayerMmrs() {
        return playerMmrInterface.findAll();
    }

    public PlayerMmr getPlayerMmrById(Integer id) {
        return playerMmrInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Player's MMR couldn't be found with the ID: " + id));
    }

    public PlayerMmr createPlayerMmr(PlayerMmr pm) {
        return playerMmrInterface.save(pm);
    }

    public PlayerMmr updatePlayerMmr(Integer id, PlayerMmr newData) {
        PlayerMmr existing = playerMmrInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Player's MMR couldn't be found with the ID: " + id));

        existing.setMmr(newData.getMmr());
        existing.setRankId(newData.getRankId());

        return playerMmrInterface.save(existing);
    }

    public void deletePlayerMmr(Integer id) {
        PlayerMmr existing = playerMmrInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Player's MMR couldn't be found with the ID: " + id));

        playerMmrInterface.delete(existing);
    }
}
