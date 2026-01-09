package com.mj.springbootlicenseplates.controller;


import com.mj.springbootlicenseplates.entity.District;
import com.mj.springbootlicenseplates.service.district.DistrictService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/districts")
@Tag(name = "Districts", description = "Endpoints for retrieving information about Polish districts (powiats)")
public class DistrictRestController {

    private final DistrictService districtService;

    @Autowired
    public DistrictRestController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @Operation(
            summary = "Get all districts",
            description = "Retrieves a complete list of all Polish districts (powiats) with their details. Districts are administrative divisions within voivodeships."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved list of all districts",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = District.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid parameter values",
                    content = @Content
            )
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<District> getAll(
            @Parameter(description = "Filter by Polish voivodeship (province) name", example = "Mazowieckie")
            @RequestParam(required = false)
            String voivodeship
    ) {
        return districtService.getAll(voivodeship);
    }
}
