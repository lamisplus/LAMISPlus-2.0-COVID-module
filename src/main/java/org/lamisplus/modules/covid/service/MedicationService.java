package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Comorbidity;
import org.lamisplus.modules.covid.domain.entity.Medication;
import org.lamisplus.modules.covid.repository.ComorbidityRepository;
import org.lamisplus.modules.covid.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicationService {
    @Autowired
    private MedicationRepository repository;

    public List<Medication> GetAllMedications() {
        return repository.findAll();
    }
}
