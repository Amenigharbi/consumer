package com.Microservices.ConsumerService.Service;

import com.Microservices.ConsumerService.AddEvent.AddEvent;
import com.Microservices.ConsumerService.Model.Enseignant;
import com.Microservices.ConsumerService.Repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnseignantService {

    @Autowired
    private EnseignantRepository enseignantRepository;

    @Transactional
    public void addEnseignant(AddEvent addEvent) {
        Enseignant enseignant = new Enseignant();
        enseignant.setNom(addEvent.getNom());
        enseignant.setPrenom(addEvent.getPrenom());
        enseignant.setMail(addEvent.getMail());
        enseignant.setGrade(addEvent.getGrade());

        enseignantRepository.save(enseignant);
    }

    @Transactional(readOnly = true)
    public Enseignant getEnseignantById(Long enseignantId) {
        return enseignantRepository.findById(enseignantId)
                .orElseThrow(() -> new IllegalArgumentException("Enseignant not found for ID: " + enseignantId));
    }

    @Transactional(readOnly = true)
    public List<Enseignant> getAllEnseignants() {
        return enseignantRepository.findAll();
    }


}
