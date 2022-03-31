package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientComorbidity;
import org.lamisplus.modules.covid.domain.entity.PatientMedication;
import org.lamisplus.modules.covid.repository.PatientComorbidityRepository;
import org.lamisplus.modules.covid.repository.PatientMedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientMedicationService {
    @Autowired
    private PatientMedicationRepository repository;

    public PatientMedication SaveMedication(PatientMedication patientMedication){
        return repository.save(patientMedication);
    }

    public List<PatientMedication> SaveAll(List<PatientMedication> patientMedications){
        return repository.saveAll(patientMedications);
    }

    public PatientMedication UpdateMedication(PatientMedication patientMedication){
        return repository.save(patientMedication);
    }

    public List<PatientMedication> GetbyPatientId(int patient_id) {
        return repository.findByPatientId(patient_id);
    }

    public String DeleteMedication(int id) {
        return repository.delete(id);
    }
}
