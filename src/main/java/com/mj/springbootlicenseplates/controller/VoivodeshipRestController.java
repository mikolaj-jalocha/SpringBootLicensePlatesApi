package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.entity.Voivodeship;
import com.mj.springbootlicenseplates.service.voivodeship.VoivodeshipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/voivodeships")
@Tag(name = "Voivodeships", description = "Endpoints for retrieving information about Polish administrative regions (voivodeships/provinces)")
public class VoivodeshipRestController {

    private final VoivodeshipService voivodeshipService;

    @Autowired
    public VoivodeshipRestController(VoivodeshipService voivodeshipService) {
        this.voivodeshipService = voivodeshipService;
    }

    @Operation(
            summary = "Get all voivodeships",
            description = "Retrieves a complete list of all 16 Polish voivodeships (provinces) with their details. Poland is divided into 16 voivodeships, which are the highest-level administrative divisions."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved list of all voivodeships",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Voivodeship.class))
            )
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Voivodeship> getAll() {
        return voivodeshipService.getAll();
    }
}