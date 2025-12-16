package com.game.matchmaking.repository;

import com.game.matchmaking.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatches extends JpaRepository<Matches, Integer> {
}
