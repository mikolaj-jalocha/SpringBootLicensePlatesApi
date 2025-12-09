package com.mj.springbootlicenseplates.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class UserScoreDto {

    @NotNull(message = "User ID must not be null")
    @Positive(message = "User ID must be positive")
    private Long userId;

    @NotNull(message = "Score must not be null")
    @Positive(message = "Score must be positive")
    private Long score;

    @NotNull(message = "Quiz start time must not be null")
    private Instant quizStart;

    @NotNull(message = "Quiz end time must not be null")
    private Instant quizEnd;
}