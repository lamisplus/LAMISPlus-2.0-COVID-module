package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Demographic;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DemographicRepository {
    private final JdbcTemplate jdbcTemplate;

    public Demographic save(Demographic demographic) {
        jdbcTemplate.update("INSERT INTO covid_demographic (uuid, sex, dob, preterm, low_birth_weight, weight," +
                        "race, hw_in_contact, pregnant_current, pregnant_within_21, pregnant_withn_42) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                UUID.randomUUID().toString(),
                demographic.getSex(),
                demographic.getDob(),
                demographic.getPreterm(),
                demographic.getLow_birth_weight(),
                demographic.getWeight(),
                demographic.getRace(),
                demographic.getHw_in_contact(),
                demographic.getPregnant_current(),
                demographic.getPregnant_within_21(),
                demographic.getPregnant_within_42());
        return findByUUID(demographic.getUuid()).orElse(null);
    }

    public Optional<Demographic> update(Demographic demographic) {
        jdbcTemplate.update("UPDATE covid_demographic set uuid=?, name=?, sex=?, dob=?, preterm=?, low_birth_weight=?, weight=?," +
                        "race=?, hw_in_contact=?, pregnant_current=?, pregnant_within_21=?, pregnant_withn_42=? where id=? ",
                demographic.getUuid(),
                demographic.getSex(),
                demographic.getDob(),
                demographic.getPreterm(),
                demographic.getLow_birth_weight(),
                demographic.getWeight(),
                demographic.getRace(),
                demographic.getHw_in_contact(),
                demographic.getPregnant_current(),
                demographic.getPregnant_within_21(),
                demographic.getPregnant_within_42(),
                demographic.getId()
        );
        return findByUUID(demographic.getUuid());
    }

    public List<Demographic> findAll() {
        return jdbcTemplate.query("SELECT * FROM covid_demographic",
                new BeanPropertyRowMapper<Demographic>(Demographic.class));
    }

    public String delete(int id){
        jdbcTemplate.update("delete from covid_demographic where id=?", id);
        return id + " deleted successfully";
    }

    public Optional<Demographic> findByUUID(String uuid) {
        return jdbcTemplate.query("SELECT * FROM covid_demographic where uuid = ?",
                new BeanPropertyRowMapper<Demographic>(Demographic.class), uuid).stream().findFirst();
    }
}
