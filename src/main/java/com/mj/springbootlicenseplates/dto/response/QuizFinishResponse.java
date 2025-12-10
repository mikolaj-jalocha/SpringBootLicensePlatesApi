package com.mj.springbootlicenseplates.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizFinishResponse {
    private Long quizId;
    private long durationSeconds;
}
