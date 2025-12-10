package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.dto.request.QuizFinish;
import com.mj.springbootlicenseplates.dto.response.QuizFinishResponse;
import com.mj.springbootlicenseplates.dto.response.QuizQuestionResponse;
import com.mj.springbootlicenseplates.entity.Voivodeship;
import com.mj.springbootlicenseplates.service.QuizService;
import com.mj.springbootlicenseplates.service.VoivodeshipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz")
@Tag(name = "Quiz", description = "Endpoints for starting and completing a quiz about registration plates")
public class QuizRestController {

    private final QuizService quizService;

    @Autowired
    public QuizRestController(QuizService quizService) {
        this.quizService = quizService;
    }

    @Operation(
            summary = "Start a new quiz",
            description = "Randomly selects 5 unique voivodeships and a registration plate from each. Saves quiz start time."
    )
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/start/{userId}")
    public List<QuizQuestionResponse> startQuiz(@PathVariable Long userId) {
        return quizService.startQuiz(userId);
    }

    @Operation(
            summary = "Finish the quiz",
            description = "Marks quiz as finished by saving end time."
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PostMapping("/finish")
    public void finishQuiz(@RequestBody QuizFinish request) {
        quizService.finishQuiz(request.getQuizId());
    }
}
