package com.game.matchmaking.analysis;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analysis")
public class PlayerAnalysisController {

    private final MatchHistoryService historyService;
    private final IPerformanceAnalyzer analyzer;

    public PlayerAnalysisController(MatchHistoryService historyService) {
        this.historyService = historyService;
        this.analyzer = new MatchPerformanceAnalyzer();
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<AnalysisResult> analyzePlayer(@PathVariable int playerId) {

        PlayerStats stats = historyService.getLatestStats(playerId);
        AnalysisResult result = analyzer.analyze(stats);
        return ResponseEntity.ok(result);
    }
}


