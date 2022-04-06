package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientVaccine;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PatientVaccineRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientVaccine save(PatientVaccine vaccine) {
        jdbcTemplate.update("INSERT INTO covid_patient_vaccine (uuid, patient_id, vaccine_date, dose, number) " +
                        "VALUES (?, ?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                vaccine.getPatient_id(),
                vaccine.getVaccine_date(),
                vaccine.getDose(),
                vaccine.getDose_number());
        return findByUUID(vaccine.getUuid()).orElse(null);
    }

    public List<PatientVaccine> saveAll(List<PatientVaccine> patientVaccines) {
        List<PatientVaccine> patientVaccineList = new ArrayList<>();
        for(PatientVaccine vaccine : patientVaccines) {
            patientVaccineList.add(save(vaccine));
        }
        return patientVaccineList;
    }

    public Optional<PatientVaccine> update(PatientVaccine vaccine) {
        jdbcTemplate.update("UPDATE covid_patient_vaccine set " +
                        "patient_id=?, vaccine_date=?, dose=?, number=? " +
                        "where id=?",
                vaccine.getUuid(),
                vaccine.getPatient_id(),
                vaccine.getVaccine_date(),
                vaccine.getDose(),
                vaccine.getDose_number(),
                vaccine.getId()
        );
        return findByUUID(vaccine.getUuid());
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_patient_vaccine where id=?", id);
        return id + " deleted successfully";
    }

    public List<PatientVaccine> findByPatientId(int patient_id) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_vaccine where patient_id = ?",
                new BeanPropertyRowMapper<PatientVaccine>(PatientVaccine.class), patient_id);
    }

    public Optional<PatientVaccine> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_vaccine where patient_id = ?",
                new BeanPropertyRowMapper<PatientVaccine>(PatientVaccine.class), uuid).stream().findFirst();
    }
}
