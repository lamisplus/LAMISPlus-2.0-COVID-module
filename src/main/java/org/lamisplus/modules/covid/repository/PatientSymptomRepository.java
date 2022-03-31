package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientSymptom;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PatientSymptomRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientSymptom save(PatientSymptom symptom) {
        jdbcTemplate.update("INSERT INTO covid_patient_symptom (uuid, patient_id, visit_date, symptom_id, symptom_value) " +
                        "VALUES (?, ?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                symptom.getPatient_id(),
                symptom.getVisit_date(),
                symptom.getSymptom_id(),
                symptom.getSymptom_value());
        return findByUUID(symptom.getUuid()).orElse(null);
    }

    public List<PatientSymptom> saveAll(List<PatientSymptom> symptoms) {
        List<PatientSymptom> patientSymptomList = new ArrayList<>();
        for(PatientSymptom symptom : symptoms) {
            patientSymptomList.add(save(symptom));
        }
        return patientSymptomList;
    }

    public Optional<PatientSymptom> update(PatientSymptom symptom) {
        jdbcTemplate.update("UPDATE covid_patient_symptom set " +
                        "patient_id=?, visit_date=?, symptom_id=?, symptom_value=? " +
                        "where id=? ",
                symptom.getUuid(),
                symptom.getPatient_id(),
                symptom.getVisit_date(),
                symptom.getSymptom_id(),
                symptom.getSymptom_value(),
                symptom.getId()
        );
        return findByUUID(symptom.getUuid());
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_patient_symptom where id=?", id);
        return id + " deleted successfully";
    }

    public List<PatientSymptom> findByPatientId(int patient_id) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_symptom where patient_id = ?",
                new BeanPropertyRowMapper<PatientSymptom>(PatientSymptom.class), patient_id);
    }

    public Optional<PatientSymptom> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_symptom where patient_id = ?",
                new BeanPropertyRowMapper<PatientSymptom>(PatientSymptom.class), uuid).stream().findFirst();
    }
}

