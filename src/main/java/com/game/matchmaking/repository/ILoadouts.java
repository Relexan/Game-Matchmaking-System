package com.game.matchmaking.repository;

import com.game.matchmaking.entity.Loadouts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoadouts extends JpaRepository<Loadouts, Integer> {
}
