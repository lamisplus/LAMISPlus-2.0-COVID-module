package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientVaccine;
import org.lamisplus.modules.covid.domain.entity.PatientVitalsign;
import org.lamisplus.modules.covid.repository.PatientVitalsignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientVitalsignService {
    @Autowired
    private PatientVitalsignRepository repository;

    public PatientVitalsign SaveVitalsign(PatientVitalsign patientVitalsign) {
        return repository.save(patientVitalsign);
    }

    public List<PatientVitalsign> SaveAll(List<PatientVitalsign> patientVitalsigns){
        return repository.saveAll(patientVitalsigns);
    }

    public PatientVitalsign UpdateVitalsign(PatientVitalsign patientVitalsign) {
        return repository.save(patientVitalsign);
    }

    public List<PatientVitalsign> GetbyPatientId(int patient_id) {
        return repository.findByPatientId(patient_id);
    }

    public String DeleteVitalsign(int id) {
        return repository.delete(id);
    }
}
