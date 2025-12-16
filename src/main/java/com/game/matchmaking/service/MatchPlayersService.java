package com.game.matchmaking.service;

import com.game.matchmaking.entity.MatchPlayers;
import com.game.matchmaking.exception.ResourceNotFoundException;
import com.game.matchmaking.repository.IMatchPlayers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchPlayersService {

    private final IMatchPlayers matchPlayersInterface;

    public MatchPlayersService(IMatchPlayers matchPlayersInterface) {
        this.matchPlayersInterface = matchPlayersInterface;
    }

    public List<MatchPlayers> getAllMatchPlayers() {
        return matchPlayersInterface.findAll();
    }

    public MatchPlayers getMatchPlayerById(Integer id) {
        return matchPlayersInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Player in this match couldn't be found with the ID: " + id));
    }

    public MatchPlayers createMatchPlayer(MatchPlayers mp) {
        return matchPlayersInterface.save(mp);
    }

    public MatchPlayers updateMatchPlayer(Integer id, MatchPlayers newData) {
        MatchPlayers existing = matchPlayersInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Player in this match couldn't be found with the ID: " + id));

        existing.setMatchId(newData.getMatchId());
        existing.setPlayerId(newData.getPlayerId());
        existing.setTeam(newData.getTeam());
        existing.setKills(newData.getKills());
        existing.setDeaths(newData.getDeaths());
        existing.setAssists(newData.getAssists());
        existing.setScore(newData.getScore());
        existing.setIsWinner(newData.getIsWinner());

        return matchPlayersInterface.save(existing);
    }

    public void deleteMatchPlayer(Integer id) {
        MatchPlayers existing = matchPlayersInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Player in this match couldn't be found with the ID: " + id));

        matchPlayersInterface.delete(existing);
    }
}
