package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientMedication;
import org.lamisplus.modules.covid.domain.entity.PatientReinfection;
import org.lamisplus.modules.covid.repository.PatientReinfectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientReinfectionService {
    @Autowired
    private PatientReinfectionRepository repository;

    public PatientReinfection Save(PatientReinfection patientReinfection){
        return repository.save(patientReinfection);
    }

    public PatientReinfection UpdateReinfection(int id, PatientReinfection patientReinfection){
        return repository.update(id, patientReinfection);
    }

    public List<PatientReinfection> GetbyPatientId(int patient_id) {
        return repository.findByPatientId(patient_id);
    }

    public String DeleteReinfection(int id) {
        return repository.delete(id);
    }
}

