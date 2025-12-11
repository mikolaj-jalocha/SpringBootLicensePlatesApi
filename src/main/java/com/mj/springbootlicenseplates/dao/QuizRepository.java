package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.dto.response.QuizResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<com.mj.springbootlicenseplates.entity.RegistrationPlate, Long> {

    @Query(value = """
            SELECT d.name AS name,
                   codes.voivodeship AS voivodeship,
                   codes.code AS code
            FROM (
                SELECT v.name AS voivodeship,
                       (SELECT rp.code
                        FROM districts d
                        INNER JOIN registration_plates rp USING(district_id)
                        WHERE d.voivodeship_id = v.voivodeship_id
                        ORDER BY RAND()
                        LIMIT 1) AS code
                FROM voivodeships v
                ORDER BY RAND()
                LIMIT 5
            ) codes
            INNER JOIN registration_plates rp ON rp.code = codes.code
            INNER JOIN districts d ON rp.district_id = d.district_id
            """, nativeQuery = true)
    List<QuizResponse> getQuizResponseNative();
}
