package com.mj.springbootlicenseplates.service.user;

import com.mj.springbootlicenseplates.dto.request.UserDto;
import com.mj.springbootlicenseplates.dto.request.UserScoreDto;
import com.mj.springbootlicenseplates.dto.response.LeaderboardResponse;
import com.mj.springbootlicenseplates.entity.User;

import java.util.List;

public interface UserService {
    User addUser(UserDto name);

    void addUserScore(UserScoreDto userScoreDto);

    List<LeaderboardResponse> getLeaderboard();
}
