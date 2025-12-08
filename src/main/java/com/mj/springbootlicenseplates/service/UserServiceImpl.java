package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dao.UserRepository;
import com.mj.springbootlicenseplates.dto.UserDto;
import com.mj.springbootlicenseplates.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(UserDto userDto) {
        if (userRepository.existsByNameNative(userDto.getName()))
            return null;
        userRepository.insertUserNative(userDto.getName());
        return userRepository.getUserNative(userDto.getName());
    }
}
