package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.entity.RegistrationPlate;
import com.mj.springbootlicenseplates.service.RegistrationPlateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/license-plates")
@Tag(name = "License Plates", description = "Endpoints for retrieving and searching Polish vehicle registration plates by code, voivodeship, district, or type")
public class RegistrationPlateRestController {

    private final RegistrationPlateService registrationPlateService;

    @Autowired
    public RegistrationPlateRestController(RegistrationPlateService registrationPlateService) {
        this.registrationPlateService = registrationPlateService;
    }

    @Operation(
            summary = "Get registration plate by code",
            description = "Retrieves detailed information about a specific registration plate using its 2-3 character code. Automatically increments the view count for analytics."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Registration plate found and returned successfully",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegistrationPlate.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid code format - must be 2-3 characters",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Registration plate not found with the provided code",
                    content = @Content
            )
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{code}")
    public RegistrationPlate getSingleRegistrationPlateByCode(
            @Parameter(description = "Registration plate code (2-3 characters, e.g., 'WA' for Warsaw, 'KR' for Krakow)", required = true, example = "WA")
            @PathVariable
            @Size(min = 2, max = 3, message = "Code must be between 2 and 3 characters")
            String code
    ) {
        RegistrationPlate registrationPlate = registrationPlateService.getSingleRegistrationPlateByCode(code);
        if (registrationPlate != null)
            registrationPlateService.incrementRegistrationPlateViews(code);
        return registrationPlate;
    }

    @Operation(
            summary = "Search registration plates",
            description = "Retrieves a filtered list of registration plates based on optional criteria. If no parameters are provided, returns all registration plates. Supports filtering by voivodeship, district, and/or type."
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "List of registration plates matching the search criteria",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegistrationPlate.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid parameter values",
                    content = @Content
            )
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<RegistrationPlate> getRegistrationPlateWithParams(
            @Parameter(description = "Filter by Polish voivodeship (province) name", example = "Mazowieckie")
            @RequestParam(required = false)
            String voivodeship,
            @Parameter(description = "Filter by district name within a voivodeship", example = "Warsaw")
            @RequestParam(required = false)
            String district,
            @Parameter(description = "Filter by registration plate type (e.g., standard, commercial, diplomatic)", example = "standard")
            @RequestParam(required = false)
            String type
    ) {
        return registrationPlateService.getRegistrationPlatesWithParams(voivodeship, district, type);
    }
}