package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Question;
import org.lamisplus.modules.covid.domain.entity.QuestionResponse;
import org.lamisplus.modules.covid.repository.QuestionRepository;
import org.lamisplus.modules.covid.repository.QuestionResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionResponseRepository questionResponseRepository;

    public List<Question> GetQuestionsByCategory(String category) {
        return questionRepository.findAllByCategory(category);
    }

    public List<QuestionResponse> GetResponsesByQuestionId(int question_id) {
        return questionResponseRepository.findAllByQuestionId(question_id);
    }
}
