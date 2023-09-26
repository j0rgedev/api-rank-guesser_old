package com.george.apirankguesser.utils;

import com.george.apirankguesser.dto.ClipDTO;
import com.george.apirankguesser.dto.ClipUploadDTO;
import com.george.apirankguesser.entity.Clip;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Mapper {
    public ClipDTO mapClipToDTO(Clip clip){
        return new ClipDTO(
                clip.getId(),
                clip.getYoutubeUrl()
        );
    }

    public String youtubeUrlToEmbedUrl(String youtubeUrl){
        if(youtubeUrl.contains("watch?v=")){
            return youtubeUrl.replace("watch?v=", "embed/");
        } else {
            return youtubeUrl.replace("youtu.be/", "youtube.com/embed/");
        }
    }
}
