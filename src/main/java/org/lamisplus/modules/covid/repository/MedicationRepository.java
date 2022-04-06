package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Comorbidity;
import org.lamisplus.modules.covid.domain.entity.Medication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MedicationRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Medication> findAll() {
        return jdbcTemplate.query("SELECT * FROM covid_medication",
                new BeanPropertyRowMapper<Medication>(Medication.class));
    }
}
