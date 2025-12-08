package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dao.RegistrationPlatesRepository;
import com.mj.springbootlicenseplates.entity.RegistrationPlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationPlatesServiceImpl implements RegistrationPlateService {

    private final RegistrationPlatesRepository service;

    @Autowired
    public RegistrationPlatesServiceImpl(RegistrationPlatesRepository registrationPlatesRepository) {
        this.service = registrationPlatesRepository;
    }

    @Override
    public List<RegistrationPlate> getAll() {
        return service.getAllLicensePlates();
    }

    @Override
    public RegistrationPlate getSingleRegistrationPlateByCode(String code) {
        return service.getSingleRegistrationPlateByCode(code);
    }

    @Override
    public List<RegistrationPlate> getRegistrationPlatesWithParams(String voivodeship, String district, String type) {
        return service.getRegistrationPlatesWithParams(voivodeship, district, type);
    }

    @Override
    public void incrementRegistrationPlateViews(String code) {
        service.incrementRegistrationPlateViews(code);
    }
}
