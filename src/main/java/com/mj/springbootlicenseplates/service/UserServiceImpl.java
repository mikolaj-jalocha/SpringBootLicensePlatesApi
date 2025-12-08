package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dao.UserRepository;
import com.mj.springbootlicenseplates.dao.UserScoreRepository;
import com.mj.springbootlicenseplates.dto.UserDto;
import com.mj.springbootlicenseplates.dto.UserScoreDto;
import com.mj.springbootlicenseplates.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            return null;
        userRepository.insertUserNative(userDto.getName());
        return userRepository.getUserNative(userDto.getName());
    }

    @Override
    public void addUserScore(UserScoreDto userScoreDto) {
        if (userRepository.existByIdNative(userScoreDto.getUserId())) {
            userScoreRepository.insertUserScoreNative(userScoreDto.getUserId(), userScoreDto.getScore(), userScoreDto.getQuizStart(), userScoreDto.getQuizEnd());
        }
    }

}
