package com.mj.springbootlicenseplates.service.quiz;

import com.mj.springbootlicenseplates.dao.QuizRepository;
import com.mj.springbootlicenseplates.dto.response.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<QuizResponse> getQuiz() {
        return quizRepository.getQuizResponseNative();
    }
}
