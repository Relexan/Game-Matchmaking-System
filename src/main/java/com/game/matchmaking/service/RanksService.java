package com.game.matchmaking.service;

import com.game.matchmaking.entity.Ranks;
import com.game.matchmaking.exception.ResourceNotFoundException;
import com.game.matchmaking.repository.IRanks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RanksService {

    private final IRanks ranksInterface;

    public RanksService(IRanks ranksInterface) {
        this.ranksInterface = ranksInterface;
    }

    public List<Ranks> getAllRanks() {
        return ranksInterface.findAll();
    }

    public Ranks getRankById(Integer id) {
        return ranksInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Rank couldn't found with the entered ID: " + id));
    }

    public Ranks createRank(Ranks rank) {
        return ranksInterface.save(rank);
    }

    public Ranks updateRank(Integer id, Ranks newData) {
        Ranks existing = ranksInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Rank couldn't found with the entered ID: " + id));

        existing.setRankName(newData.getRankName());
        existing.setMinMmr(newData.getMinMmr());
        existing.setMaxMmr(newData.getMaxMmr());

        return ranksInterface.save(existing);
    }

    public void deleteRank(Integer id) {
        Ranks existing = ranksInterface.findById(id).orElseThrow(() ->
                        new ResourceNotFoundException("Rank couldn't found with the entered ID: " + id));

        ranksInterface.delete(existing);
    }
}
