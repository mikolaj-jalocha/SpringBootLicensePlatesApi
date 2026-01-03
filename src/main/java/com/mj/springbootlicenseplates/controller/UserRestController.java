package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.dto.request.UserDto;
import com.mj.springbootlicenseplates.dto.request.UserScoreDto;
import com.mj.springbootlicenseplates.dto.response.LeaderboardResponse;
import com.mj.springbootlicenseplates.entity.User;
import com.mj.springbootlicenseplates.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Tag(name = "Users and Games", description = "Endpoints for managing users, recording quiz scores, and retrieving leaderboard data")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create a new user",
            description = "Registers a new user in the system. The username must be unique. Returns the created user object with generated ID."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "User created successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input data - validation failed",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "User with this name already exists",
                    content = @Content
            )
    })
    public User addUser(
            @Parameter(description = "User data containing the username", required = true)
            @RequestBody
            @Valid
            UserDto userDto
    ) {
        return userService.addUser(userDto);
    }

    @PostMapping("/scores")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Record user quiz score",
            description = "Submits a user's quiz score along with quiz start and end timestamps. Used to track quiz performance."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Score recorded successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input data - validation failed or invalid timestamps",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User not found with the provided ID",
                    content = @Content
            )
    })
    public void addUserScore(
            @Parameter(description = "Quiz score data including user ID, score value, and timestamps", required = true)
            @RequestBody
            @Valid
            UserScoreDto userScoreDto
    ) {
        userService.addUserScore(userScoreDto);
    }

    @GetMapping("/scores")
    @Operation(
            summary = "Get leaderboard",
            description = "Retrieves the global leaderboard showing top users ranked by their quiz scores in descending order."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Leaderboard retrieved successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = LeaderboardResponse.class))
            )
    })
    @ResponseStatus(HttpStatus.OK)
    public List<LeaderboardResponse> getLeaderboard() {
        return userService.getLeaderboard();
    }
}