package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Comorbidity;
import org.lamisplus.modules.covid.domain.entity.PatientComorbidity;
import org.lamisplus.modules.covid.repository.ComorbidityRepository;
import org.lamisplus.modules.covid.repository.PatientComorbidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientComorbidityService {
    @Autowired
    private PatientComorbidityRepository repository;

    public List<PatientComorbidity> Save(List<PatientComorbidity> patientComorbidities){
        return repository.saveAll(patientComorbidities);
    }

    public PatientComorbidity UpdateComorbidity(int id, PatientComorbidity patientComorbidity){
        return repository.save(patientComorbidity);
    }

    public List<PatientComorbidity> GetbyPatientId(int patient_id) {
        return repository.findByPatientId(patient_id);
    }

    public String DeleteComorbidity(int id) {
        return repository.delete(id);
    }
}
