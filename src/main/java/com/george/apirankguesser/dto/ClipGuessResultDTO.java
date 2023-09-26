package com.george.apirankguesser.dto;

public record ClipGuessResultDTO(
        int points,
        String guessedRank,
        String actualRank
) {
}
