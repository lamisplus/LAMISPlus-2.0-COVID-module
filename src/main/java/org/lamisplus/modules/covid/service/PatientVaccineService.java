package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientSymptom;
import org.lamisplus.modules.covid.domain.entity.PatientVaccine;
import org.lamisplus.modules.covid.repository.PatientVaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientVaccineService {
    @Autowired
    private PatientVaccineRepository repository;

    public PatientVaccine SaveVaccine(PatientVaccine patientVaccine){
        return repository.save(patientVaccine);
    }

    public PatientVaccine UpdateVaccine(PatientVaccine patientVaccine){
        return repository.save(patientVaccine);
    }

    public List<PatientVaccine> SaveAll(List<PatientVaccine> patientVaccines){
        return repository.saveAll(patientVaccines);
    }

    public List<PatientVaccine> GetbyPatientId(int patient_id) {
        return repository.findByPatientId(patient_id);
    }

    public String DeleteVaccine(int id) {
        return repository.delete(id);
    }
}