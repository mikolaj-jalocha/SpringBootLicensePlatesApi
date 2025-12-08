package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.dto.UserDto;
import com.mj.springbootlicenseplates.entity.User;
import com.mj.springbootlicenseplates.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users Rest API Endpoints", description = "Operations related to users. ")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(
            @RequestBody
            @Valid
            UserDto userDto
    ) {
        return userService.addUser(userDto);
    }

}
