package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientReinfection;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class PatientReinfectionRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientReinfection save(PatientReinfection reinfection) {
        jdbcTemplate.update("INSERT INTO covid_patient_reinfection (uuid, patient_id, visit_date, previous_episode, onset_date," +
                        "confirmed, admitted, admission_date) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                reinfection.getPatient_id(),
                reinfection.getVisit_date(),
                reinfection.getPrevious_episode(),
                reinfection.getOnset_date(),
                reinfection.getConfirmed(),
                reinfection.getAdmitted(),
                reinfection.getAdmission_date());
        return findByUUID(reinfection.getUuid()).orElse(null);
    }

    public List<PatientReinfection> saveAll(List<PatientReinfection> comorbidities) {
        List<PatientReinfection> reinfectionList = new ArrayList<>();
        for(PatientReinfection reinfection : comorbidities) {
            reinfectionList.add(save(reinfection));
        }

        return reinfectionList;
    }

    public Optional<PatientReinfection> update(PatientReinfection reinfection) {
        jdbcTemplate.update("UPDATE covid_patient_reinfection set " +
                        "patient_id=?, visit_date=?, reinfection_id=?, reinfection_value=? " +
                        "where id=?",
                reinfection.getUuid(),
                reinfection.getPatient_id(),
                reinfection.getVisit_date(),
                reinfection.getPrevious_episode(),
                reinfection.getOnset_date(),
                reinfection.getConfirmed(),
                reinfection.getAdmitted(),
                reinfection.getAdmission_date(),
                reinfection.getId()
        );
        return findByUUID(reinfection.getUuid());
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_patient_reinfection where id=?", id);
        return id + " deleted successfully";
    }

    public List<PatientReinfection> findByPatientId(int patient_id) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_reinfection where patient_id = ?",
                new BeanPropertyRowMapper<PatientReinfection>(PatientReinfection.class), patient_id);
    }

    public Optional<PatientReinfection> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_reinfection where patient_id = ?",
                new BeanPropertyRowMapper<PatientReinfection>(PatientReinfection.class), uuid).stream().findFirst();
    }
}

