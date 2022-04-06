package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Vaccine;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VaccineRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Vaccine> findAll() {
        return jdbcTemplate.query("SELECT * FROM covid_vaccine",
                new BeanPropertyRowMapper<Vaccine>(Vaccine.class));
    }
}
