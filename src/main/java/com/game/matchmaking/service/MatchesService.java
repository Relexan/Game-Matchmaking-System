package com.game.matchmaking.service;

import com.game.matchmaking.entity.Matches;
import com.game.matchmaking.exception.ResourceNotFoundException;
import com.game.matchmaking.repository.IMatches;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesService {

    private final IMatches matchesInterface;

    public MatchesService(IMatches matchesInterface) {
        this.matchesInterface = matchesInterface;
    }

    public List<Matches> getAllMatches() {
        return matchesInterface.findAll();
    }

    public Matches getMatchById(Integer id) {
        return matchesInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Match couldn't found with the ID: " + id));
    }

    public Matches createMatch(Matches match) {
        return matchesInterface.save(match);
    }

    public Matches updateMatch(Integer id, Matches newData) {
        Matches existing = matchesInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Match couldn't found with the ID: " + id));

        existing.setMatchDate(newData.getMatchDate());
        existing.setMapName(newData.getMapName());
        existing.setGameMode(newData.getGameMode());
        existing.setMatchStatus(newData.getMatchStatus());
        existing.setDurationSeconds(newData.getDurationSeconds());

        return matchesInterface.save(existing);
    }

    public void deleteMatch(Integer id) {
        Matches existing = matchesInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Match couldn't found with the ID: " + id));

        matchesInterface.delete(existing);
    }
}
