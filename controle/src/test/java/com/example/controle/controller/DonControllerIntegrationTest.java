package com.example.controle.controller;

import com.example.controle.dto.DonDTO;
import com.example.controle.model.Campagne;
import com.example.controle.repository.CampagneRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DonControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CampagneRepository campagneRepository;

    @Test
    void getCampagnesActives_ShouldReturnActiveCampagnes() throws Exception {
        // Arrange
        Campagne campagne = new Campagne();
        campagne.setNom("Test Campagne");
        campagne.setObjectifMontant(new BigDecimal("1000"));
        campagne.setDateDebut(LocalDate.now().minusDays(1));
        campagne.setDateFin(LocalDate.now().plusDays(1));
        campagneRepository.save(campagne);

        // Act & Assert
        mockMvc.perform(get("/api/campagnes/actives"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nom").value("Test Campagne"))
                .andExpect(jsonPath("$[0].objectifMontant").value("1000"));
    }

    @Test
    void enregistrerDon_ShouldCreateDon() throws Exception {
        // Arrange
        Campagne campagne = new Campagne();
        campagne.setNom("Test Campagne");
        campagne.setObjectifMontant(new BigDecimal("1000"));
        campagne.setDateDebut(LocalDate.now().minusDays(1));
        campagne.setDateFin(LocalDate.now().plusDays(1));
        campagneRepository.save(campagne);

        DonDTO donDTO = new DonDTO();
        donDTO.setNomCampagne("Test Campagne");
        donDTO.setNomDonateur("John Doe");
        donDTO.setMontant(new BigDecimal("100"));
        donDTO.setDate(LocalDate.now());

        // Act & Assert
        mockMvc.perform(post("/api/campagnes/1/dons")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(donDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomDonateur").value("John Doe"))
                .andExpect(jsonPath("$.montant").value("100"));
    }
} 