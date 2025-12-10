package com.mj.springbootlicenseplates.dto.response;

import com.mj.springbootlicenseplates.entity.District;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizQuestionResponse {
    private String code;
    private String voivodeship;
    private String district;

    public QuizQuestionResponse(String code, String voivodeship, District district) {
        this.code = code;
        this.voivodeship = voivodeship;
        this.district = district.getName();
    }
}

