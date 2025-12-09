package com.mj.springbootlicenseplates.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LeaderboardResponse {
    private Long position;
    private String userName;
    private Long totalScore;
}
