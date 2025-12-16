package com.game.matchmaking.analysis;

public abstract class BaseAnalyzer {

    public String ratio(double value) {
        if (value >= 1.5) return "Great";
        if (value >= 1.0) return "Good";
        return "Needs Improvement";
    }

    public abstract AnalysisResult analyze(PlayerStats stats);
}


