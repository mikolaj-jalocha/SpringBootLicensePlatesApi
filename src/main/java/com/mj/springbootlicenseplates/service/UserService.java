package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dto.UserDto;
import com.mj.springbootlicenseplates.entity.User;

public interface UserService {
    public User addUser(UserDto name);
}
