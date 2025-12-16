package com.game.matchmaking.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Match_Players")
public class MatchPlayers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_player_id")
    private Integer matchPlayerId;

    @Column(name = "match_id")
    private Integer matchId;

    @Column(name = "player_id")
    private Integer playerId;

    // ENUM('ALPHA','BRAVO')
    @Column(name = "team")
    private String team;

    @Column(name = "kills")
    private Integer kills;

    @Column(name = "deaths")
    private Integer deaths;

    @Column(name = "assists")
    private Integer assists;

    @Column(name = "score")
    private Integer score;

    @Column(name = "is_winner", nullable = false)
    private Boolean isWinner;

    public MatchPlayers() {}

    public Integer getMatchPlayerId() {
        return matchPlayerId;
    }

    public void setMatchPlayerId(Integer matchPlayerId) {
        this.matchPlayerId = matchPlayerId;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getKills() {
        return kills;
    }

    public void setKills(Integer kills) {
        this.kills = kills;
    }

    public Integer getDeaths() {
        return deaths;
    }

    public void setDeaths(Integer deaths) {
        this.deaths = deaths;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Boolean getIsWinner() {
        return isWinner;
    }

    public void setIsWinner(Boolean isWinner) {
        this.isWinner = isWinner;
    }
}
