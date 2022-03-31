package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientComorbidity;
import org.lamisplus.modules.covid.domain.entity.PatientMedication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PatientMedicationRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientMedication save(PatientMedication medication) {
        jdbcTemplate.update("INSERT INTO covid_patient_medication (uuid, patient_id, visit_date, medication_id, medication_value) " +
                        "VALUES (?, ?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                medication.getPatient_id(),
                medication.getVisit_date(),
                medication.getMedication_id(),
                medication.getMedication_value()
        );
        return findByUUID(medication.getUuid()).orElse(null);
    }

    public List<PatientMedication> saveAll(List<PatientMedication> medications) {
        List<PatientMedication> patientMedications = new ArrayList<>();

        for(PatientMedication medication : medications) {
            patientMedications.add(save(medication));
        }
        return patientMedications;
    }

    public Optional<PatientMedication> update(PatientMedication medication) {
        jdbcTemplate.update("UPDATE covid_patient_medication set " +
                        "patient_id=?, visit_date=?, medication_id=?, medication_value=? " +
                        "where id=?",
                medication.getUuid(),
                medication.getPatient_id(),
                medication.getVisit_date(),
                medication.getMedication_id(),
                medication.getMedication_value(),
                medication.getId()
        );
        return findByUUID(medication.getUuid()
        );
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_patient_medication where id=?", id);
        return id + " deleted successfully";
    }

    public List<PatientMedication> findByPatientId(int patient_id) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_medication where patient_id = ?",
                new BeanPropertyRowMapper<>(PatientMedication.class), patient_id);
    }

    public Optional<PatientMedication> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_medication where patient_id = ?",
                new BeanPropertyRowMapper<PatientMedication>(PatientMedication.class), uuid).stream().findFirst();
    }
}
