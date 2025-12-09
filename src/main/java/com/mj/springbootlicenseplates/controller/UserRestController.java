package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.dto.request.UserDto;
import com.mj.springbootlicenseplates.dto.request.UserScoreDto;
import com.mj.springbootlicenseplates.dto.response.LeaderboardResponse;
import com.mj.springbootlicenseplates.entity.User;
import com.mj.springbootlicenseplates.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users and Games Rest API Endpoints", description = "Operations related to users and quiz.")
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
    public void addUserScore(
            @RequestBody
            @Valid
            UserScoreDto userScoreDto
    ) {
        userService.addUserScore(userScoreDto);
    }

    @GetMapping("/scores")
    @Operation(summary = "Get leaderboard", description = "Returns the leaderboard ordered by score descending.")
    @ResponseStatus(HttpStatus.OK)
    public List<LeaderboardResponse> getLeaderboard() {
        return userService.getLeaderboard();
    }

}
