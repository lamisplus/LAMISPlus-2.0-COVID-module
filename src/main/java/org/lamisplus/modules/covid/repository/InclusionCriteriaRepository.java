package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.InclusionCriteria;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class InclusionCriteriaRepository {
    private final JdbcTemplate jdbcTemplate;

    public InclusionCriteria save(InclusionCriteria inclusionCriteria) {
        jdbcTemplate.update("INSERT INTO covid_inclusioncriteria (uuid, covid_signs, covid_test, test_date) " +
                        "VALUES (?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                inclusionCriteria.getCovid_signs(),
                inclusionCriteria.getCovid_test(),
                inclusionCriteria.getTest_date()
        );
        return findByUUID(inclusionCriteria.getUuid()).orElse(null);
    }

    public Optional<InclusionCriteria> update(InclusionCriteria inclusionCriteria) {
        jdbcTemplate.update("UPDATE covid_patient set uuid=?, covid_signs=?, covid_test=?, test_date=? " +
                        "where id=? ",
                inclusionCriteria.getCovid_signs(),
                inclusionCriteria.getCovid_test(),
                inclusionCriteria.getTest_date(),
                inclusionCriteria.getId()
        );
        return findByUUID(inclusionCriteria.getUuid());
    }

    public List<InclusionCriteria> findAll() {
        return jdbcTemplate.query("SELECT * FROM covid_inclusioncriteria",
                new BeanPropertyRowMapper<InclusionCriteria>(InclusionCriteria.class));
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_inclusioncriteria where id=?", id);
        return id + " deleted successfully";
    }

    public Optional<InclusionCriteria> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_inclusioncriteria where uuid = ?",
                new BeanPropertyRowMapper<InclusionCriteria>(InclusionCriteria.class), uuid).stream().findFirst();
    }
}
