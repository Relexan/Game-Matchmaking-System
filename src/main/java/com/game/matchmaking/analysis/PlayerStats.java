package com.game.matchmaking.analysis;

public record PlayerStats(
        int playerId,
        int kills,
        int deaths,
        int assists,
        int mmrBefore,
        int mmrAfter,
        int score
) {}


