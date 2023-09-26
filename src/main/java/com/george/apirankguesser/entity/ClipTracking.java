package com.george.apirankguesser.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "clip_tracking")
@Entity
public class ClipTracking {
    @Id
    private UUID id;

    @Column(name = "clip_id")
    private UUID clipId;

    @Column(name = "selected_date")
    private LocalDate selectedDate;
}
