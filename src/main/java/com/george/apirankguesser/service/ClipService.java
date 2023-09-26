package com.george.apirankguesser.service;

import com.george.apirankguesser.dto.ClipDTO;
import com.george.apirankguesser.dto.ClipGuessBody;
import com.george.apirankguesser.dto.ClipGuessResultDTO;
import com.george.apirankguesser.dto.ClipUploadDTO;
import com.george.apirankguesser.entity.Clip;
import com.george.apirankguesser.entity.ClipTracking;
import com.george.apirankguesser.exception.BusinessException;
import com.george.apirankguesser.repository.ClipRepository;
import com.george.apirankguesser.repository.ClipTrackingRepository;
import com.george.apirankguesser.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*
* Service class that handles the business logic for the Clip entity such as:
* - Generating the daily clips
* - Saving a clip
* - Checking if a guess was correct
*
* @Service annotation is used to mark the class as a service provider
* @Author: Jorge Antezana
* */
@Service
public class ClipService {

    private final List<Clip> dailyClips = new ArrayList<>();
    private final ClipScoringService clipScoringService;
    private final ClipRepository clipRepository;
    private final ClipTrackingRepository clipTrackingRepository;
    private final Mapper mapper;

    @Autowired
    public ClipService(ClipScoringService clipScoringService, ClipRepository clipRepository, ClipTrackingRepository clipTrackingRepository, Mapper mapper) {
        this.clipScoringService = clipScoringService;
        this.clipRepository = clipRepository;
        this.clipTrackingRepository = clipTrackingRepository;
        this.mapper = mapper;
    }

    /*
    * Main function to generate the daily clips
    * @Return void
    * */
    public void generateDailyClips() {
        List<Clip> randomClips = clipRepository.selectRandomUnselectedClips();
        clearDailyClips();
        addDailyClips(randomClips);
        //saveClipTracking(randomClips);
    }

    // TODO: Implement
    public void addClip(ClipUploadDTO clipUploadDTO){
    }

    /*
    * Function to check if the guess was correct
    * @Param clipGuessDTO: The DTO containing the clip id and the guessed rank
    * @Return boolean: True if the guess was correct, false otherwise
    * */
    public ClipGuessResultDTO isRankGuessCorrect(String clipId, ClipGuessBody clipGuessBody){
        UUID uuid = UUID.fromString(clipId);
        Clip clip = findDailyClipById(uuid);
        String actualRank = clip.getPlayerRank();

        int score = clipScoringService.calculateScore(clipGuessBody.guessedRank(), actualRank);

        return new ClipGuessResultDTO(
                score,
                clipGuessBody.guessedRank(),
                clip.getPlayerRank()
        );
    }

    private Clip findDailyClipById(UUID id){
        return dailyClips.stream()
                .filter(clip -> clip.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND, "Clip not selected for today"));
    }

    private void clearDailyClips() {
        dailyClips.clear();
    }

    private void addDailyClips(List<Clip> clips) {
        dailyClips.addAll(clips);
    }

    private void saveClipTracking(List<Clip> clips){
        LocalDate date = LocalDate.now();
        for(Clip clip : clips){
            ClipTracking clipTracking = new ClipTracking(
                    UUID.randomUUID(),
                    clip.getId(),
                    date
            );
            clipTrackingRepository.save(clipTracking);
        }
    }

    // Getters
    public List<ClipDTO> getDailyClips(){
        List<ClipDTO> clipDTOs = dailyClips.stream()
                .map(mapper::mapClipToDTO)
                .toList();

        clipDTOs.forEach(clipDTO -> clipDTO.setYoutube_url(mapper.youtubeUrlToEmbedUrl(clipDTO.getYoutube_url())));

        return clipDTOs;
    }
}
