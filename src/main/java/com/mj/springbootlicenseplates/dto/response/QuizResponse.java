package com.mj.springbootlicenseplates.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuizResponse {
    private String district;
    private String voivodeship;
    private String code;
}
