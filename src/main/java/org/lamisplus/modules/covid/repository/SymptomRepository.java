package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Symptom;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class SymptomRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Symptom> findAll() {
        return jdbcTemplate.query("SELECT * FROM covid_symptom",
                new BeanPropertyRowMapper<Symptom>(Symptom.class));
    }
}
