package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dto.response.QuizFinishResponse;
import com.mj.springbootlicenseplates.dto.response.QuizQuestionResponse;

import java.util.List;

public interface QuizService {
    List<QuizQuestionResponse> startQuiz(Long userId);
    void finishQuiz(Long quizId);
}


