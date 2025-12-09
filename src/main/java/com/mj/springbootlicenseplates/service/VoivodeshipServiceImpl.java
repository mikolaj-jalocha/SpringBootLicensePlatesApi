package com.mj.springbootlicenseplates.service;

import com.mj.springbootlicenseplates.dao.VoivodeshipRepository;
import com.mj.springbootlicenseplates.entity.Voivodeship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoivodeshipServiceImpl implements VoivodeshipService {

    private final VoivodeshipRepository voivodeshipRepository;

    @Autowired
    public VoivodeshipServiceImpl(VoivodeshipRepository voivodeshipRepository) {
        this.voivodeshipRepository = voivodeshipRepository;
    }

    @Override
    public List<Voivodeship> getAll() {
        // return voivodeshipRepository.findAll();
        return voivodeshipRepository.getAllVoivodeshipsNative();
    }
}
