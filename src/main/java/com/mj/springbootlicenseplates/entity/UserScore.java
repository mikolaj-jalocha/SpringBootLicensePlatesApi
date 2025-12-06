package com.mj.springbootlicenseplates.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "users_scores")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_score_id")
    private Long userScoreId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User user;

    private Long score;

    @Column(name = "quiz_start")
    private Instant quizStart;

    @Column(name = "quiz_end")
    private Instant quizEnd;
}
