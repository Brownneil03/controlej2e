package com.example.controle.controller;

import com.example.controle.dto.DonDTO;
import com.example.controle.projection.CampagneResume;
import com.example.controle.service.ServiceCampagne;
import com.example.controle.service.ServiceDon;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DonController {
    private final ServiceCampagne serviceCampagne;
    private final ServiceDon serviceDon;

    @GetMapping("/campagnes/actives")
    public ResponseEntity<List<CampagneResume>> getCampagnesActives() {
        return ResponseEntity.ok(serviceCampagne.getCampagnesActives());
    }

    @PostMapping("/campagnes/{id}/dons")
    public ResponseEntity<DonDTO> enregistrerDon(@PathVariable Long id, @Valid @RequestBody DonDTO donDTO) {
        return ResponseEntity.ok(serviceDon.enregistrerDon(id, donDTO));
    }
} 