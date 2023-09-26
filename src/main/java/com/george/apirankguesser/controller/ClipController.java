package com.george.apirankguesser.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.george.apirankguesser.dto.ClipDTO;
import com.george.apirankguesser.dto.ClipGuessBody;
import com.george.apirankguesser.dto.ClipGuessResultDTO;
import com.george.apirankguesser.service.ClipService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clip")
@Validated
public class ClipController {

    private final ClipService clipService;

    @Autowired
    public ClipController(ClipService clipService) {
        this.clipService = clipService;
    }

    @GetMapping
    public ResponseEntity<List<ClipDTO>> getClips() {
        return ResponseEntity.ok(clipService.getDailyClips());
    }

    @PostMapping("/{clipId}/guess")
    public ResponseEntity<ClipGuessResultDTO> checkGuess(
            @PathVariable
            @NotNull
            @NotBlank
            @Pattern(regexp = "[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}")
            String clipId,
            @RequestBody @Validated ClipGuessBody clipGuessBody) {
        return ResponseEntity.ok(clipService.isRankGuessCorrect(clipId, clipGuessBody));
    }
}