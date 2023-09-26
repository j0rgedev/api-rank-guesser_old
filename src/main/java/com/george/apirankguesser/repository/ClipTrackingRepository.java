package com.george.apirankguesser.repository;

import com.george.apirankguesser.entity.Clip;
import com.george.apirankguesser.entity.ClipTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClipTrackingRepository extends JpaRepository<ClipTracking, UUID> {
}
