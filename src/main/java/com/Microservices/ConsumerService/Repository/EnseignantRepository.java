package com.Microservices.ConsumerService.Repository;

import com.Microservices.ConsumerService.Model.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {
    List<Enseignant> findAll();
}
