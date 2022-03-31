package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Comorbidity;
import org.lamisplus.modules.covid.domain.entity.Vaccine;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ComorbidityRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Comorbidity> findAll() {
        return jdbcTemplate.query("SELECT * FROM covid_comorbidity",
                new BeanPropertyRowMapper<Comorbidity>(Comorbidity.class));
    }
}
