package com.george.apirankguesser.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Setter
@Getter
public class ClipDTO {
    UUID id;
    String youtube_url;
}
