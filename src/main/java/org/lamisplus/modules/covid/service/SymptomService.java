package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Medication;
import org.lamisplus.modules.covid.domain.entity.Symptom;
import org.lamisplus.modules.covid.repository.MedicationRepository;
import org.lamisplus.modules.covid.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SymptomService {
    @Autowired
    private SymptomRepository repository;

    public List<Symptom> GetAllSymptoms() {
        return repository.findAll();
    }
}
