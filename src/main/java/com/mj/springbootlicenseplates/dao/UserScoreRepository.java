package com.mj.springbootlicenseplates.dao;

import com.mj.springbootlicenseplates.dto.response.LeaderboardResponse;
import com.mj.springbootlicenseplates.entity.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

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


    //    @Query(
//            value = "SELECT u.name AS userName, COALESCE(MAX(us.score), 0) AS score " +
//                    "FROM users u LEFT JOIN users_scores us ON u.user_id = us.user_id " +
//                    "GROUP BY u.user_id, u.name " +
//                    "ORDER BY score DESC",
//            nativeQuery = true
//    )
    @Query(
            value = "SELECT " +
                    "  ROW_NUMBER() OVER (ORDER BY COALESCE(MAX(us.score), 0) DESC) AS position, " +
                    "  u.name AS userName, " +
                    "  COALESCE(MAX(us.score), 0) AS totalScore " +
                    "FROM users u " +
                    "LEFT JOIN users_scores us ON u.user_id = us.user_id " +
                    "GROUP BY u.user_id, u.name " +
                    "ORDER BY totalScore DESC",
            nativeQuery = true
    )
    List<LeaderboardResponse> getLeaderboardNative();
}