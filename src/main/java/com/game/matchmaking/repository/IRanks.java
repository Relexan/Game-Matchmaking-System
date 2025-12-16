package com.game.matchmaking.repository;

import com.game.matchmaking.entity.Ranks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRanks extends JpaRepository<Ranks, Integer> {
}
