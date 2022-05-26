package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.PatientStatusDTO;
import org.lamisplus.modules.covid.domain.entity.CodeSet;
import org.lamisplus.modules.covid.domain.entity.PatientStatus;
import org.lamisplus.modules.covid.domain.mapper.CovidMapper;
import org.lamisplus.modules.covid.repository.PatientStatusRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PatientStatusService {
    private final PatientStatusRepository repository;
    private final CovidMapper mapper;

    public PatientStatusDTO SaveStatus(PatientStatusDTO patientStatusDTO){
        PatientStatus patientStatus = mapper.toPatientStatus(patientStatusDTO);
        return mapper.toPatientStatusDto(repository.save(patientStatus));
    }

    public PatientStatusDTO UpdateStatus(PatientStatusDTO patientStatusDTO){
        PatientStatus patientStatus = mapper.toPatientStatus(patientStatusDTO);
        return mapper.toPatientStatusDto(repository.save(patientStatus));
    }

    public PatientStatusDTO GetStatusByPatientId(int patient_id) {
        return mapper.toPatientStatusDto(repository.findByPatientId(patient_id));
    }

    public String DeleteStatus(int id) {
        PatientStatus patientStatus = repository.findById(id).orElse(null);
        repository.delete(patientStatus);
        return id + " deleted successfully";
    }

    public List<CodeSet> GetVaccinationStatusCodeSet(){
        //return repository.FindVaccinationStatusCodesets();
        return null;
    }

    public List<CodeSet> GetCurrentStatusCodeSet(){
        //return repository.FindCurrentStatusCodesets();
        return null;
    }
}
