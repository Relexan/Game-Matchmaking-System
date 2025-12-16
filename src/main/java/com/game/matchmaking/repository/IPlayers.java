package com.game.matchmaking.repository;

import com.game.matchmaking.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayers extends JpaRepository<Players, Integer> {
}
