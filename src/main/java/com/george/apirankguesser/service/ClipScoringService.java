package com.george.apirankguesser.service;

import com.george.apirankguesser.dto.ValorantRank;
import com.george.apirankguesser.exception.BusinessException;
import com.george.apirankguesser.utils.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ClipScoringService {

    public int calculateScore(String guessedRankName, String actualRankName) {
        ValorantRank guessedRank = getValorantRank(guessedRankName);
        ValorantRank actualRank = getValorantRank(actualRankName);
        if (guessedRank.rankNumber() == actualRank.rankNumber()) {
            return 200;
        } else if (guessedRank.rankNumber() == actualRank.rankNumber() - 1 ||
                guessedRank.rankNumber() == actualRank.rankNumber() + 1) {
            return 100;
        } else if (guessedRank.rankNumber() == actualRank.rankNumber() - 2 ||
                guessedRank.rankNumber() == actualRank.rankNumber() + 2) {
            return 50;
        }
        return 0;
    }

    private ValorantRank getValorantRank(String rankName) {
        return Constants.VALORANT_RANKS.stream()
                .filter(valorantRank -> valorantRank.rank().equalsIgnoreCase(rankName))
                .findFirst()
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Rank not found: " + rankName));
    }
}
