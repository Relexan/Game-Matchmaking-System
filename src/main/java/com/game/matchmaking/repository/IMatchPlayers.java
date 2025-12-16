package com.game.matchmaking.repository;

import com.game.matchmaking.entity.MatchPlayers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatchPlayers extends JpaRepository<MatchPlayers, Integer> {
}
