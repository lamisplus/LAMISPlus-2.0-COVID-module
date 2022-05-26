package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.PatientDTO;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.lamisplus.modules.covid.domain.mapper.CovidMapper;
import org.lamisplus.modules.covid.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;
    private final CovidMapper mapper;

    public PatientDTO SavePatient(PatientDTO patientDTO){
        Patient patient = mapper.toPatient(patientDTO);
        return mapper.toPatientDto(repository.save(patient));
    }

    public PatientDTO UpdatePatient(int id, PatientDTO patientDTO){
        Patient patient = mapper.toPatient(patientDTO);
        return mapper.toPatientDto(repository.save(patient));
    }

    public List<PatientDTO> GetAllPatients() {
        return mapper.toPatientDtoList(repository.findAll());
    }

    public String DeletePatient(int id) {
        Patient patient = repository.findById(id).orElse(null);
        repository.delete(patient);
        return id+" deleted successfully";
    }
}
