package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dao.QuizRepository;
import com.mj.springbootlicenseplates.dto.response.QuizFinishResponse;
import com.mj.springbootlicenseplates.dto.response.QuizQuestionResponse;
import com.mj.springbootlicenseplates.entity.RegistrationPlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;

    @Autowired
    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<QuizQuestionResponse> startQuiz(Long userId) {
        List<String> allVoivodeships = List.of(
                "Mazowieckie", "Małopolskie", "Śląskie", "Wielkopolskie",
                "Dolnośląskie", "Pomorskie", "Łódzkie", "Lubelskie",
                "Podlaskie", "Podkarpackie", "Lubuskie", "Świętokrzyskie",
                "Opolskie", "Zachodniopomorskie", "Kujawsko-Pomorskie", "Warmińsko-Mazurskie"
        );

        Collections.shuffle(allVoivodeships);
        List<String> selected = allVoivodeships.subList(0, 5);

        List<QuizQuestionResponse> questions = new ArrayList<>();
        for (String voivodeship : selected) {
            RegistrationPlate plate = quizRepository.findRandomByVoivodeship(voivodeship);
            questions.add(new QuizQuestionResponse(
                    plate.getCode(),
                    voivodeship,
                    plate.getDistrict()
            ));
        }

        quizRepository.startQuiz(userId, LocalDateTime.now());
        return questions;
    }

    @Override
    public void finishQuiz(Long quizId) {
        quizRepository.finishQuiz(quizId, LocalDateTime.now());
    }
}
