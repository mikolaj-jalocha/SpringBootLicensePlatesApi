package com.mj.springbootlicenseplates.controller;

import com.mj.springbootlicenseplates.entity.RegistrationPlate;
import com.mj.springbootlicenseplates.service.RegistrationPlateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/license-plates")
@Tag(name = "License plates Rest API Endpoints", description = "Operations related to license plates")
public class RegistrationPlateRestController {

    private final RegistrationPlateService registrationPlateService;

    @Autowired
    public RegistrationPlateRestController(RegistrationPlateService registrationPlateService) {
        this.registrationPlateService = registrationPlateService;
    }

    @Operation(summary = "Get single registration plate", description = "Retrieve a single registration plates.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{code}")
    public RegistrationPlate getSingleRegistrationPlateByCode(
            @PathVariable
            @Size(min = 2, max = 3)
            String code
    ){
        RegistrationPlate registrationPlate = registrationPlateService.getSingleRegistrationPlateByCode(code);
        if (registrationPlate != null)
            registrationPlateService.incrementRegistrationPlateViews(code);
        return registrationPlate;
    }

    @Operation(summary = "Get every registration plate", description = "Get every registration plate")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<RegistrationPlate> getRegistrationPlateWithParams(
            @Parameter(description = "Voivodeship assigned to registration plate")
            @RequestParam(required = false)
            String voivodeship,
            @Parameter(description = "District assigned to registration plate")
            @RequestParam(required = false)
            String district,
            @Parameter(description = "Type assigned to registration plate")
            @RequestParam(required = false)
            String type
    ){
        return registrationPlateService.getRegistrationPlatesWithParams(voivodeship,district,type);
    }


}
