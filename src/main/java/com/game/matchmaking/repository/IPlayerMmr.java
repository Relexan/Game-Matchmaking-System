package com.game.matchmaking.repository;

import com.game.matchmaking.entity.PlayerMmr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerMmr extends JpaRepository<PlayerMmr, Integer> {
}
