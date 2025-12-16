package com.game.matchmaking.repository;

import com.game.matchmaking.entity.Weapons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IWeapons extends JpaRepository<Weapons, Integer> {
}


