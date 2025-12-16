package com.game.matchmaking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Ranks")
public class Ranks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rank_id")
    private Integer rankId;

    @Column(name = "rank_name")
    private String rankName;

    @Column(name = "min_mmr")
    private Integer minMmr;

    @Column(name = "max_mmr")
    private Integer maxMmr;

    public Ranks() {}

    public Integer getRankId() {
        return rankId;
    }

    public void setRankId(Integer rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    public Integer getMinMmr() {
        return minMmr;
    }

    public void setMinMmr(Integer minMmr) {
        this.minMmr = minMmr;
    }

    public Integer getMaxMmr() {
        return maxMmr;
    }

    public void setMaxMmr(Integer maxMmr) {
        this.maxMmr = maxMmr;
    }
}
