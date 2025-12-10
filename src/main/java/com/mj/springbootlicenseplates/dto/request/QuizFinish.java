package com.mj.springbootlicenseplates.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizFinish {
    @NotNull(message = "Quiz ID must not be null")
    @Positive(message = "Quiz ID must be positive")
    private Long quizId;
}
