package com.mj.springbootlicenseplates.service.quiz;

import com.mj.springbootlicenseplates.dto.response.QuizResponse;

import java.util.List;

public interface QuizService {
    List<QuizResponse> getQuiz();
}
