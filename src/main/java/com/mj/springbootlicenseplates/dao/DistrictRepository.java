package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    @Query(value = """
            SELECT d.* FROM districts d 
            JOIN voivodeships v ON d.voivodeship_id = v.voivodeship_id 
            WHERE (:voivodeship IS NULL OR LOWER(v.name) = LOWER(:voivodeship))
            """,
            nativeQuery = true)
    List<District> getAllDistrictsNative(@Param("voivodeship") String voivodeship);
}