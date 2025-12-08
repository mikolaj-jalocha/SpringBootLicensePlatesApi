package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.entity.RegistrationPlate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RegistrationPlatesRepository extends JpaRepository<RegistrationPlate, Long> {
    @Query(value = "SELECT * FROM registration_plates", nativeQuery = true)
    List<RegistrationPlate> getAllLicensePlates();

    @Query(value = "SELECT * FROM registration_plates WHERE code = :code", nativeQuery = true)
    RegistrationPlate getSingleRegistrationPlateByCode(@Param("code") String code);

    @Query(value = """
    SELECT rp.* FROM registration_plates rp
    JOIN districts d ON rp.district_id = d.district_id
    JOIN voivodeships v ON d.voivodeship_id = v.voivodeship_id
    JOIN registration_types rt ON rp.type_id = rt.registration_type_id
    WHERE (:voivodeship IS NULL OR v.name = :voivodeship)
    AND (:district IS NULL OR d.name = :district)
    AND (:type IS NULL OR rt.type = :type)
    """, nativeQuery = true)
    List<RegistrationPlate> getRegistrationPlatesWithParams(
            @Param("voivodeship") String voivodeship,
            @Param("district") String district,
            @Param("type") String type
    );
    @Modifying
    @Transactional
    @Query(value = """
    UPDATE registration_plates 
    SET number_of_views = number_of_views + 1 
    WHERE code = :code
    """, nativeQuery = true)
    void incrementRegistrationPlateViews(@Param("code") String code);
}

