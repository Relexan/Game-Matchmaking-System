package com.game.matchmaking.service;

import com.game.matchmaking.entity.Players;
import com.game.matchmaking.exception.ResourceNotFoundException;
import com.game.matchmaking.repository.IPlayers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {

    private final IPlayers playersInterface;

    public PlayersService(IPlayers playersInterface) {
        this.playersInterface = playersInterface;
    }

    public List<Players> getAllPlayers() {
        return playersInterface.findAll();
    }

    public Players getPlayerById(Integer id) {
        return playersInterface.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Player couldn't be found with the ID: " + id));
    }

    public Players createPlayer(Players player) {
        return playersInterface.save(player);
    }

    public Players updatePlayer(Integer id, Players newData) {
        Players existing = playersInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Player couldn't be found with the ID: " + id));

        existing.setUsername(newData.getUsername());
        existing.setEmail(newData.getEmail());
        existing.setRegion(newData.getRegion());
        existing.setRegistrationDate(newData.getRegistrationDate());

        return playersInterface.save(existing);
    }

    public void deletePlayer(Integer id) {
        Players existing = playersInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Player couldn't be found with the ID: " + id));

        playersInterface.delete(existing);
    }
}
