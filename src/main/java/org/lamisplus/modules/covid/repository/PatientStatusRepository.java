package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PatientStatusRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientStatus save(PatientStatus patientStatus) {
        jdbcTemplate.update("INSERT INTO covid_patientstatus (uuid, patient_id, status_id) " +
                        "VALUES (?, ?, ?)",
                UUID.randomUUID().toString(),
                patientStatus.getPatient_id(),
                patientStatus.getStatus_id()
        );
        return findByUUID(patientStatus.getUuid()).orElse(null);
    }

    public Optional<PatientStatus> update(PatientStatus vaccine) {
        jdbcTemplate.update("UPDATE covid_patientstatus set " +
                        "uuid=?, patient_id=?, status_id=? " +
                        "where id=?",
                vaccine.getUuid(),
                vaccine.getPatient_id(),
                vaccine.getStatus_id()
        );
        return findByUUID(vaccine.getUuid());
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_patientstatus where id=?", id);
        return id + " deleted successfully";
    }

    public Optional<PatientStatus> findByPatientId(Long patient_id) {
        return jdbcTemplate.query("SELECT * FROM covid_patientstatus where patient_id = ?",
                new BeanPropertyRowMapper<PatientStatus>(PatientStatus.class), patient_id).stream().findFirst();
    }

    public Optional<PatientStatus> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_patientstatus where patient_id = ?",
                new BeanPropertyRowMapper<PatientStatus>(PatientStatus.class), uuid).stream().findFirst();
    }
}
