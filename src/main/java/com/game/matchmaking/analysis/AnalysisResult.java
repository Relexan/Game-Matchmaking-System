package com.game.matchmaking.analysis;

public class AnalysisResult {

    private final double kdaRatio;
    private final String performanceTag;
    private final String mmrChange;

    public AnalysisResult(double kdaRatio, String performanceTag, String mmrChange) {
        this.kdaRatio = kdaRatio;
        this.performanceTag = performanceTag;
        this.mmrChange = mmrChange;
    }

    public double getKdaRatio() {
        return kdaRatio;
    }

    public String getPerformanceTag() {
        return performanceTag;
    }

    public String getMmrChange() {
        return mmrChange;
    }

}


