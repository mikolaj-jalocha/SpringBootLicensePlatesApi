package com.mj.springbootlicenseplates.service.district;

import com.mj.springbootlicenseplates.entity.District;

import java.util.List;

public interface DistrictService {
    List<District> getAll(String voivodeship);
}
