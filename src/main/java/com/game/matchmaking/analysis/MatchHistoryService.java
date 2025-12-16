package com.game.matchmaking.analysis;

import com.game.matchmaking.entity.MatchPlayers;
import com.game.matchmaking.entity.PlayerMmr;
import com.game.matchmaking.repository.IMatchPlayers;
import com.game.matchmaking.repository.IPlayerMmr;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class MatchHistoryService {

    private final IMatchPlayers matchRepo;
    private final IPlayerMmr mmrRepo;

    public MatchHistoryService(IMatchPlayers matchRepo, IPlayerMmr mmrRepo) {
        this.matchRepo = matchRepo;
        this.mmrRepo = mmrRepo;
    }

    public PlayerStats getLatestStats(int playerId) {

        List<MatchPlayers> history = matchRepo.findAll()
                .stream()
                .filter(matchPlayer -> matchPlayer.getPlayerId() == playerId)
                .sorted(Comparator.comparing(MatchPlayers::getMatchPlayerId).reversed())
                .toList();

        if (history.isEmpty()) {
            throw new RuntimeException("Player has no match history");
        }

        MatchPlayers last = history.get(0);
        PlayerMmr mmr = mmrRepo.findById(playerId)
                .orElseThrow(() -> new RuntimeException("MMR not found"));

        int mmrBefore = mmr.getMmr() - (last.getIsWinner() ? 25 : -15);
        int mmrAfter = mmr.getMmr();

        return new PlayerStats(
                playerId,
                last.getKills(),
                last.getDeaths(),
                last.getAssists(),
                mmrBefore,
                mmrAfter,
                last.getScore()
        );
    }
}
