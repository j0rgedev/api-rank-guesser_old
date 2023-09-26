package com.george.apirankguesser.repository;

import com.george.apirankguesser.entity.Clip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClipRepository extends JpaRepository<Clip, UUID> {

    @Query(value = "SELECT * FROM select_random_unselected_clips()", nativeQuery = true)
    List<Clip> selectRandomUnselectedClips();
}
