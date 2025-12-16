package com.game.matchmaking.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Loadouts")
public class Loadouts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loadout_id")
    private Integer loadoutId;

    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "loadout_name")
    private String loadoutName;

    @Column(name = "is_active")
    private Integer isActive;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Loadouts() {}

    public Integer getLoadoutId() {
        return loadoutId;
    }

    public void setLoadoutId(Integer loadoutId) {
        this.loadoutId = loadoutId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getLoadoutName() {
        return loadoutName;
    }

    public void setLoadoutName(String loadoutName) {
        this.loadoutName = loadoutName;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
