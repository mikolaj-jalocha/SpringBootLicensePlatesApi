package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dto.UserDto;
import com.mj.springbootlicenseplates.dto.UserScoreDto;
import com.mj.springbootlicenseplates.entity.User;

public interface UserService {
    User addUser(UserDto name);

    void addUserScore(UserScoreDto userScoreDto);
}
