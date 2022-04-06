package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientComorbidity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PatientComorbidityRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientComorbidity save(PatientComorbidity comorbidity) {
        jdbcTemplate.update("INSERT INTO covid_patient_comorbidity (uuid, patient_id, visit_date, comorbidity_id, comorbidity_value) " +
                        "VALUES (?, ?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                comorbidity.getPatient_id(),
                comorbidity.getVisit_date(),
                comorbidity.getComorbidity_id(),
                comorbidity.getComorbidity_value());
        return findByUUID(comorbidity.getUuid()).orElse(null);
    }

    public List<PatientComorbidity> saveAll(List<PatientComorbidity> comorbidities) {
        List<PatientComorbidity> patientComorbidities = new ArrayList<>();

        for(PatientComorbidity comorbidity : comorbidities) {
            patientComorbidities.add(save(comorbidity));
        }
        return patientComorbidities;
    }

    public Optional<PatientComorbidity> update(PatientComorbidity comorbidity) {
        jdbcTemplate.update("UPDATE covid_patient_comorbidity set " +
                        "patient_id=?, visit_date=?, comorbidity_id=?, comorbidity_value=?" +
                        "where id=? ",
                comorbidity.getUuid(),
                comorbidity.getPatient_id(),
                comorbidity.getVisit_date(),
                comorbidity.getComorbidity_id(),
                comorbidity.getComorbidity_value(),
                comorbidity.getId()
        );

        return findByUUID(comorbidity.getUuid());
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_patient_comorbidity where id=?", id);
        return id + " deleted successfully";
    }

    public List<PatientComorbidity> findByPatientId(int patient_id) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_comorbidity where patient_id = ?",
                new BeanPropertyRowMapper<>(PatientComorbidity.class), patient_id);
    }

    public Optional<PatientComorbidity> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_comorbidity where patient_id = ?",
                new BeanPropertyRowMapper<PatientComorbidity>(PatientComorbidity.class), uuid).stream().findFirst();
    }
}
