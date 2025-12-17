package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    @Query(value = "SELECT * FROM districts", nativeQuery = true)
    List<District> getAllDistrictsNative();
}