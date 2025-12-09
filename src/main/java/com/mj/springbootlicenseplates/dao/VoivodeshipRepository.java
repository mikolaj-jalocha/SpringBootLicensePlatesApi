package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.entity.Voivodeship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoivodeshipRepository extends JpaRepository<Voivodeship, Long> {
    @Query(value = "SELECT * FROM voivodeships", nativeQuery = true)
    List<Voivodeship> getAllVoivodeshipsNative();
}

