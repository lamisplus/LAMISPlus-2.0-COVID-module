package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PatientRepository {
    private final JdbcTemplate jdbcTemplate;

    public Patient save(Patient patient) {
        jdbcTemplate.update("INSERT INTO covid_patient (uuid, first_name, mid_name, " +
                        "last_name, participant_id, gender, dob, phone) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                patient.getFirst_name(),
                patient.getMid_name(),
                patient.getLast_name(),
                patient.getParticipant_id(),
                patient.getGender(),
                patient.getDob(),
                patient.getPhone()
        );
        return findByUUID(patient.getUuid()).orElse(null);
    }

    public Optional<Patient> update(Patient patient) {
        jdbcTemplate.update("UPDATE covid_patient set uuid=?, name=?, sex=?, dob=?, preterm=?, low_birth_weight=?, weight=?," +
                        "race=?, hw_in_contact=?, pregnant_current=?, pregnant_within_21=?, pregnant_withn_42=? where id=? ",
                patient.getUuid(),
                patient.getFirst_name(),
                patient.getMid_name(),
                patient.getLast_name(),
                patient.getParticipant_id(),
                patient.getGender(),
                patient.getDob(),
                patient.getPhone()
        );
        return findByUUID(patient.getUuid());
    }

    public List<Patient> findAll() {
        return jdbcTemplate.query("SELECT * FROM covid_patient",
                new BeanPropertyRowMapper<Patient>(Patient.class));
    }

    public String delete(int id){
        jdbcTemplate.update("delete from patient where id=?", id);
        return id + " deleted successfully";
    }

    public Optional<Patient> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_patient where uuid = ?",
                new BeanPropertyRowMapper<Patient>(Patient.class), uuid).stream().findFirst();
    }
}
