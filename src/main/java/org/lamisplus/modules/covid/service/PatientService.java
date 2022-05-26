package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.PatientDTO;
import org.lamisplus.modules.covid.domain.dto.PatientStatusDTO;
import org.lamisplus.modules.covid.domain.entity.Encounter;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.lamisplus.modules.covid.domain.mapper.CovidMapper;
import org.lamisplus.modules.covid.repository.EncounterRepository;
import org.lamisplus.modules.covid.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository repository;
    private final EncounterRepository encounterRepository;
    private final CovidMapper mapper;

    public PatientDTO SavePatient(PatientDTO patientDTO){
        Patient patient = mapper.toPatient(patientDTO);
        return mapper.toPatientDto(repository.save(SetVaccinationStatus(patient)));
    }

    public PatientDTO UpdatePatient(int id, PatientDTO patientDTO){
        Patient patient = mapper.toPatient(patientDTO);
        return mapper.toPatientDto(repository.save(SetVaccinationStatus(patient)));
    }

    public List<PatientDTO> GetAllPatients() {
        List<Patient> patients = repository.findAll();
        List<Patient> patientsWithStatus = new ArrayList<>();
        for(Patient patient : patients){
            patientsWithStatus.add(SetVaccinationStatus(patient));
        }
        return mapper.toPatientDtoList(patientsWithStatus);
    }

    public String DeletePatient(int id) {
        Patient patient = repository.findById(id).orElse(null);
        repository.delete(patient);
        return id+" deleted successfully";
    }

    public Patient SetVaccinationStatus(Patient patient){
        List<Encounter> encounters = encounterRepository.findEncountersByPatientIdAndCategory(patient.getId(), "VACCINATION");

        String vaccinationStatus = "";

        if(encounters.size()==0){
            vaccinationStatus = "Not Vaccinated"; //1
        }
        else if(encounters.size()==1)
        {
            vaccinationStatus = "Partially Vaccinated"; //2
        }
        else{
            vaccinationStatus = "Fully Vaccinated"; //3
        }
        patient.setVaccinationStatus(vaccinationStatus);
        return patient;
    }

    public PatientStatusDTO SaveStatus(PatientStatusDTO patientStatusDTO){
        Patient patient = repository.findById(patientStatusDTO.getPatientId()).orElse(null);
        patient.setCurrentStatus(patientStatusDTO.getCurrentStatus());
        return patientStatusDTO;
    }

    public PatientStatusDTO UpdateStatus(PatientStatusDTO patientStatusDTO){
        Patient patient = repository.findById(patientStatusDTO.getPatientId()).orElse(null);
        patient.setCurrentStatus(patientStatusDTO.getCurrentStatus());
        return patientStatusDTO;
    }

    public PatientStatusDTO GetStatusByPatientId(int patientId) {
        Patient patient = repository.findById(patientId).orElse(null);
        PatientStatusDTO patientStatusDTO = new PatientStatusDTO();
        patientStatusDTO.setId(1);
        patientStatusDTO.setPatientId(patientId);
        patientStatusDTO.setCurrentStatus(patient.getCurrentStatus());
        return patientStatusDTO;
    }

    public String DeleteStatus(int patientId) {
        Patient patient = repository.findById(patientId).orElse(null);
        patient.setCurrentStatus("");
        return patientId + " status deleted successfully";
    }
}
