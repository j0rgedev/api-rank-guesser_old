package com.george.apirankguesser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "clip")
@Entity
public class Clip {
    @Id
    private UUID id;

    @Column(name = "youtube_url")
    private String youtubeUrl;

    @Column(name = "player_rank")
    private String playerRank;

    @Enumerated(EnumType.STRING)
    @Column(name = "review_status")
    private ReviewStatus reviewStatus;

    @Column(name = "upload_timestamp")
    private Timestamp uploadTimestamp;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public enum ReviewStatus {
        Pending,
        Approved,
        Rejected
    }
}
