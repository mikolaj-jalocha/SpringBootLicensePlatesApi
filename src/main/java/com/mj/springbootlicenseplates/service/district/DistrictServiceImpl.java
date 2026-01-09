package com.mj.springbootlicenseplates.service.district;

import com.mj.springbootlicenseplates.dao.DistrictRepository;
import com.mj.springbootlicenseplates.entity.District;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<District> getAll(String voivodeship) {
        return districtRepository.getAllDistrictsNative(voivodeship);
    }
}
