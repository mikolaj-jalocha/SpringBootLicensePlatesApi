package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.entity.RegistrationPlate;

import java.util.List;

public interface RegistrationPlateService {
    List<RegistrationPlate> getAll();

    RegistrationPlate getSingleRegistrationPlateByCode(String code);

    List<RegistrationPlate> getRegistrationPlatesWithParams(String voivodeship, String district, String type);

    List<RegistrationPlate> getRegistrationPlatesContaining(String code);

    void incrementRegistrationPlateViews(String code);
}
