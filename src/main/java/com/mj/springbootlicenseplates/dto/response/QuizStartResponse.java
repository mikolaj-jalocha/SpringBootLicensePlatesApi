package com.mj.springbootlicenseplates.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuizStartResponse {
    private Long quizId;
    private List<QuizQuestionResponse> questions;
}
