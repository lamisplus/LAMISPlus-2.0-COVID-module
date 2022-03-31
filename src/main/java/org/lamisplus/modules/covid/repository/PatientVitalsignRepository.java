package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.PatientVitalsign;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class PatientVitalsignRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientVitalsign save(PatientVitalsign patientVitalSign) {
        jdbcTemplate.update("INSERT INTO covid_patient_vitalsign (uuid, patient_id, visit_date, symptom_date, admission_date" +
                        "transfer_in, temp, heart_rate, resp_rate, bp_systolic, bp_diastolic, oxygen_sat, patient_oxygen," +
                        "arm_circum, height, weight) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                patientVitalSign.getPatient_id(),
                patientVitalSign.getVisit_date(),
                patientVitalSign.getSymptom_date(),
                patientVitalSign.getAdmission_date(),
                patientVitalSign.getTransfer_in(),
                patientVitalSign.getTemp(),
                patientVitalSign.getHeart_rate(),
                patientVitalSign.getResp_rate(),
                patientVitalSign.getBp_systolic(),
                patientVitalSign.getBp_diastolic(),
                patientVitalSign.getOxygen_sat(),
                patientVitalSign.getPatient_oxygen(),
                patientVitalSign.getArm_circum(),
                patientVitalSign.getHeight(),
                patientVitalSign.getWeight()
        );
        return findByUUID(patientVitalSign.getUuid()).orElse(null);
    }

    public List<PatientVitalsign> saveAll(List<PatientVitalsign> patientVitalsigns) {
        List<PatientVitalsign> patientVitalsignList = new ArrayList<>();
        for(PatientVitalsign patientVitalSign : patientVitalsigns) {
            patientVitalsignList.add(save(patientVitalSign));
        }
        return patientVitalsignList;
    }

    public Optional<PatientVitalsign> update(PatientVitalsign patientVitalSign) {
        jdbcTemplate.update("UPDATE covid_patient_vitalsign set " +
                        "uuid=?, patient_id=?, visit_date=?, symptom_date=?, admission_date=?, " +
                        "transfer_in=?, temp=?, heart_rate=?, resp_rate=?, bp_systolic=?, bp_diastolic=?, " +
                        "oxygen_sat=?, patient_oxygen=?, arm_circum=?, height=?, weight=? " +
                        "where id=? ",
                patientVitalSign.getUuid(),
                patientVitalSign.getPatient_id(),
                patientVitalSign.getVisit_date(),
                patientVitalSign.getSymptom_date(),
                patientVitalSign.getAdmission_date(),
                patientVitalSign.getTransfer_in(),
                patientVitalSign.getTemp(),
                patientVitalSign.getHeart_rate(),
                patientVitalSign.getResp_rate(),
                patientVitalSign.getBp_systolic(),
                patientVitalSign.getBp_diastolic(),
                patientVitalSign.getOxygen_sat(),
                patientVitalSign.getPatient_oxygen(),
                patientVitalSign.getArm_circum(),
                patientVitalSign.getHeight(),
                patientVitalSign.getWeight(),
                patientVitalSign.getId()
        );
        return findByUUID(patientVitalSign.getUuid());
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_patient_vitalsign where id=?", id);
        return id + " deleted successfully";
    }

    public List<PatientVitalsign> findByPatientId(int patient_id) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_vitalsign where patient_id = ?",
                new BeanPropertyRowMapper<PatientVitalsign>(PatientVitalsign.class), patient_id);
    }

    public Optional<PatientVitalsign> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_patient_vitalsign where patient_id = ?",
                new BeanPropertyRowMapper<PatientVitalsign>(PatientVitalsign.class), uuid).stream().findFirst();
    }
}
