package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Question;
import org.lamisplus.modules.covid.domain.entity.Symptom;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<Question> findAllByCategory(String category) {
        return jdbcTemplate.query("SELECT * FROM covid_question where category=? ",
                new BeanPropertyRowMapper<Question>(Question.class), category);
    }
}
