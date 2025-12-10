package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.entity.RegistrationPlate;
import com.mj.springbootlicenseplates.entity.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
@Repository
public interface QuizRepository extends JpaRepository<UserScore, Long> {

    @Query(value = """
            SELECT rp.* FROM registration_plates rp
            JOIN districts d ON rp.district_id = d.district_id
            JOIN voivodeships v ON d.voivodeship_id = v.voivodeship_id
            WHERE LOWER(v.name) = LOWER(:voivodeship)
            ORDER BY RAND()
            LIMIT 1
            """, nativeQuery = true)
    RegistrationPlate findRandomByVoivodeship(@Param("voivodeship") String voivodeship);

    @Modifying
    @Transactional
    @Query(value = """
            INSERT INTO user_scores (user_id, quiz_start)
            VALUES (:userId, :quizStart)
            """, nativeQuery = true)
    void startQuiz(@Param("userId") Long userId, @Param("quizStart") LocalDateTime quizStart);

    @Modifying
    @Transactional
    @Query(value = """
            UPDATE user_scores
            SET quiz_end = :quizEnd
            WHERE id = :quizId
            """, nativeQuery = true)
    void finishQuiz(@Param("quizId") Long quizId, @Param("quizEnd") LocalDateTime quizEnd);
}
