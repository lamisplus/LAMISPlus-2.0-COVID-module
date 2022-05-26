package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientStatusRepository  extends JpaRepository<PatientStatus, Integer> {
    PatientStatus findByPatientId(Integer patientId);
}
