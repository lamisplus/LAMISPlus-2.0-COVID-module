package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.lamisplus.modules.covid.domain.entity.PatientStatus;
import org.lamisplus.modules.covid.repository.PatientStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientStatusService {
    @Autowired
    private PatientStatusRepository repository;

    public PatientStatus SaveStatus(PatientStatus patientStatus){
        return repository.save(patientStatus);
    }

    public PatientStatus UpdateStatus(PatientStatus patientStatus){
        return repository.save(patientStatus);
    }

    public PatientStatus GetbyPatientId(Long patient_id) {
        return repository.findByPatientId(patient_id).orElse(null);
    }

    public String DeleteStatus(int id) {
        return repository.delete(id);
    }
}
