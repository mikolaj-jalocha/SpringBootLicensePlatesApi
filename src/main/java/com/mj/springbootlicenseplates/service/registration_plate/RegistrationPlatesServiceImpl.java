package com.mj.springbootlicenseplates.service.registration_plate;

import com.mj.springbootlicenseplates.dao.RegistrationPlatesRepository;
import com.mj.springbootlicenseplates.entity.RegistrationPlate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationPlatesServiceImpl implements RegistrationPlateService {

    private final RegistrationPlatesRepository repository;

    @Autowired
    public RegistrationPlatesServiceImpl(RegistrationPlatesRepository registrationPlatesRepository) {
        this.repository = registrationPlatesRepository;
    }

    @Override
    public RegistrationPlate getSingleRegistrationPlateByCode(String code) {
        return repository.getRegistrationPlateByCodeNative(code);
    }

    @Override
    public List<RegistrationPlate> getRegistrationPlatesWithParams(String voivodeship, String district, String type) {
        return repository.getRegistrationPlatesNative(voivodeship, district, type);
    }

    @Override
    public void incrementRegistrationPlateViews(String code) {
        repository.incrementRegistrationPlateViewsNative(code);
    }

    @Override
    public List<RegistrationPlate> getRegistrationPlatesContaining(String code) {
        return repository.getRegistrationPlatesContainingNative(code);
    }
}
