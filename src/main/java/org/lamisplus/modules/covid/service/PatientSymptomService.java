package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientReinfection;
import org.lamisplus.modules.covid.domain.entity.PatientSymptom;
import org.lamisplus.modules.covid.repository.PatientSymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientSymptomService {
    @Autowired
    private PatientSymptomRepository repository;

    public List<PatientSymptom> Save(List<PatientSymptom> patientSymptoms){
        return repository.saveAll(patientSymptoms);
    }

    public PatientSymptom UpdateSymptom(int id, PatientSymptom patientSymptom){
        return repository.save(patientSymptom);
    }

    public List<PatientSymptom> GetbyPatientId(int patient_id) {
        return repository.findByPatientId(patient_id);
    }

    public String DeleteSymptom(int id) {
        return repository.delete(id);
    }
}
