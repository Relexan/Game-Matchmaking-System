package com.game.matchmaking.analysis;

public class MatchPerformanceAnalyzer extends BaseAnalyzer implements IPerformanceAnalyzer {

    @Override
    public AnalysisResult analyze(PlayerStats stats) {

        double deaths = stats.deaths();

        double kills = stats.kills();
        double assists = stats.assists();
        double total = kills + assists;

        double kda = total / deaths;

        String tag = ratio(kda);

        int before = stats.mmrBefore();
        int after = stats.mmrAfter();
        int difference = after - before;

        String text = "";

        if (difference > 0) {
            text = "+" + difference;
        } else {
            text = "" + difference;
        }

        AnalysisResult result = new AnalysisResult(kda, tag, text);

        return result;
    }
}


