package com.game.matchmaking.repository;

import com.game.matchmaking.entity.LoadoutWeapons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILoadoutWeapons extends JpaRepository<LoadoutWeapons, Integer> {
}
