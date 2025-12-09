package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dao.UserRepository;
import com.mj.springbootlicenseplates.dao.UserScoreRepository;
import com.mj.springbootlicenseplates.dto.request.UserDto;
import com.mj.springbootlicenseplates.dto.request.UserScoreDto;
import com.mj.springbootlicenseplates.dto.response.LeaderboardResponse;
import com.mj.springbootlicenseplates.entity.User;
import com.mj.springbootlicenseplates.exception.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserScoreRepository userScoreRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserScoreRepository userScoreRepository) {
        this.userRepository = userRepository;
        this.userScoreRepository = userScoreRepository;
    }

    @Override
    public User addUser(UserDto userDto) {
        if (userRepository.existsByNameNative(userDto.getName()))
            throw new UserAlreadyExistsException("User with name '" + userDto.getName() + "' already exists");
        userRepository.insertUserNative(userDto.getName());
        return userRepository.getUserNative(userDto.getName());
    }

    @Override
    public void addUserScore(UserScoreDto userScoreDto) {
        if (userRepository.existByIdNative(userScoreDto.getUserId())) {
            userScoreRepository.insertUserScoreNative(userScoreDto.getUserId(), userScoreDto.getScore(), userScoreDto.getQuizStart(), userScoreDto.getQuizEnd());
        }
    }

    @Override
    public List<LeaderboardResponse> getLeaderboard() {
        return userScoreRepository.getLeaderboardNative();
    }
}
