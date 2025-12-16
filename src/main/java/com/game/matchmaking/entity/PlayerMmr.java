package com.game.matchmaking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Player_MMR")
public class PlayerMmr {

    @Id
    @Column(name = "player_id")
    private Integer playerId;

    @Column(name = "mmr")
    private Integer mmr;

    @Column(name = "rank_id")
    private Integer rankId;

    public PlayerMmr() {}

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getMmr() {
        return mmr;
    }

    public void setMmr(Integer mmr) {
        this.mmr = mmr;
    }

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }
}
