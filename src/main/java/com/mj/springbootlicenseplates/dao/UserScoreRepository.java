package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.entity.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

public interface UserScoreRepository extends JpaRepository<UserScore, Long> {

    @Modifying
    @Transactional
    @Query(
            value = "INSERT INTO users_scores (user_id, score, quiz_start, quiz_end) " +
                    "VALUES (:userId, :score, :quizStart, :quizEnd)",
            nativeQuery = true
    )
    void insertUserScoreNative(
            @Param("userId") Long userId,
            @Param("score") Long score,
            @Param("quizStart") Instant quizStart,
            @Param("quizEnd") Instant quizEnd
    );
}