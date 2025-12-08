package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.dto.UserDto;
import com.mj.springbootlicenseplates.dto.UserScoreDto;
import com.mj.springbootlicenseplates.entity.User;
import com.mj.springbootlicenseplates.entity.UserScore;
import com.mj.springbootlicenseplates.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users Rest API Endpoints", description = "Operations related to users.")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new user", description = "Adds a new user to the system with the provided name.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public User addUser(
            @RequestBody
            @Valid
            UserDto userDto
    ) {
        return userService.addUser(userDto);
    }

    @PostMapping("/scores")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Record user quiz score", description = "Records a user's quiz score with start and end times.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User score recorded successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public void addUserScore(
            @RequestBody
            @Valid
            UserScoreDto userScoreDto
    ) {
        userService.addUserScore(userScoreDto);
    }

}
