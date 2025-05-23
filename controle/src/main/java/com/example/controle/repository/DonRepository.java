package com.example.controle.repository;

import com.example.controle.model.Don;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DonRepository extends JpaRepository<Don, Long> {
    List<Don> findByCampagneId(Long campagneId);
} 