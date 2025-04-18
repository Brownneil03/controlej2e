package com.example.controle.service;

import com.example.controle.projection.CampagneResume;
import com.example.controle.repository.CampagneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCampagne {
    private final CampagneRepository campagneRepository;

    public List<CampagneResume> getCampagnesActives() {
        return campagneRepository.findActiveCampagnes(LocalDate.now());
    }
} 