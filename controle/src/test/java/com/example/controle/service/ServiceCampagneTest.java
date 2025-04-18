package com.example.controle.service;

import com.example.controle.projection.CampagneResume;
import com.example.controle.repository.CampagneRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ServiceCampagneTest {

    @Mock
    private CampagneRepository campagneRepository;

    @InjectMocks
    private ServiceCampagne serviceCampagne;

    @Test
    void getCampagnesActives_ShouldReturnActiveCampagnes() {
        // Arrange
        CampagneResume campagne1 = new CampagneResume() {
            @Override
            public Long getId() { return 1L; }
            @Override
            public String getNom() { return "Campagne 1"; }
            @Override
            public BigDecimal getObjectifMontant() { return new BigDecimal("1000"); }
        };

        when(campagneRepository.findActiveCampagnes(LocalDate.now()))
            .thenReturn(List.of(campagne1));

        // Act
        List<CampagneResume> result = serviceCampagne.getCampagnesActives();

        // Assert
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getId()).isEqualTo(1L);
        assertThat(result.get(0).getNom()).isEqualTo("Campagne 1");
        assertThat(result.get(0).getObjectifMontant()).isEqualTo(new BigDecimal("1000"));
    }
} 