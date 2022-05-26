package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Encounter;
import org.lamisplus.modules.covid.domain.entity.QuestionAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter, Integer> {
    List<Encounter> findEncountersByPatientId(Integer patientId);
}
