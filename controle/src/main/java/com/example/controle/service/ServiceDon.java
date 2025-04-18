package com.example.controle.service;

import com.example.controle.dto.DonDTO;
import com.example.controle.model.Campagne;
import com.example.controle.model.Don;
import com.example.controle.repository.CampagneRepository;
import com.example.controle.repository.DonRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceDon {
    private final DonRepository donRepository;
    private final CampagneRepository campagneRepository;

    @Transactional
    public DonDTO enregistrerDon(Long campagneId, DonDTO donDTO) {
        Campagne campagne = campagneRepository.findById(campagneId)
                .orElseThrow(() -> new EntityNotFoundException("Campagne non trouvée avec l'ID: " + campagneId));

        Don don = new Don();
        don.setCampagne(campagne);
        don.setNomDonateur(donDTO.getNomDonateur());
        don.setMontant(donDTO.getMontant());
        don.setDate(donDTO.getDate());

        Don savedDon = donRepository.save(don);
        return convertToDTO(savedDon);
    }

    private DonDTO convertToDTO(Don don) {
        DonDTO dto = new DonDTO();
        dto.setId(don.getId());
        dto.setNomCampagne(don.getCampagne().getNom());
        dto.setNomDonateur(don.getNomDonateur());
        dto.setMontant(don.getMontant());
        dto.setDate(don.getDate());
        return dto;
    }
} 