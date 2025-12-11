package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.dao.QuizRepository;
import com.mj.springbootlicenseplates.dto.response.QuizResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@Tag(name = "Quiz", description = "Endpoint for generating quiz questions")
public class QuizController {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizController(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Operation(
            summary = "Get quiz questions",
            description = "Generates 5 random rows with code, voivodeship, and district"
    )
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<QuizResponse> getQuiz() {
        return quizRepository.getQuizResponseNative();
    }
}
