package org.lamisplus.modules.covid.repository;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Question;
import org.lamisplus.modules.covid.domain.entity.QuestionResponse;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class QuestionResponseRepository {
    private final JdbcTemplate jdbcTemplate;

    public List<QuestionResponse> findAllByQuestionId(int question_id) {
        return jdbcTemplate.query("SELECT * FROM covid_question_response where question_id=? ",
                new BeanPropertyRowMapper<QuestionResponse>(QuestionResponse.class), question_id);
    }
}
