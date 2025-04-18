package com.example.controle.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class Don {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campagne_id", nullable = false)
    private Campagne campagne;

    @NotBlank(message = "Le nom du donateur est obligatoire")
    private String nomDonateur;

    @NotNull(message = "Le montant est obligatoire")
    @Positive(message = "Le montant doit être positif")
    private BigDecimal montant;

    @NotNull(message = "La date est obligatoire")
    private LocalDate date;

    // Constructeur sans argument requis par JPA
    public Don() {
    }
} 