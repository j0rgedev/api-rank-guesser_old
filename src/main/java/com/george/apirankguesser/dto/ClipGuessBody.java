package com.george.apirankguesser.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClipGuessBody(@NotNull @NotBlank String guessedRank) { }
