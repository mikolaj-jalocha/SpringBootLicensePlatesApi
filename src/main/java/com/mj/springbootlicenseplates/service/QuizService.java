package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dto.response.QuizResponse;

import java.util.List;

public interface QuizService {
    List<QuizResponse> getQuiz();
}
