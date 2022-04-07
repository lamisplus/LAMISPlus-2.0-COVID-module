package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.PatientReinfection;
import org.lamisplus.modules.covid.domain.entity.Question;
import org.lamisplus.modules.covid.domain.entity.QuestionResponse;
import org.lamisplus.modules.covid.domain.entity.Symptom;
import org.lamisplus.modules.covid.service.QuestionService;
import org.lamisplus.modules.covid.service.SymptomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/")
public class CovidQuestionController {
    private final QuestionService service;

    @GetMapping("/questions-by-category/{category}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category){
        return ResponseEntity.ok(service.GetQuestionsByCategory(category));
    }

    @GetMapping("/questions/{question_id}/responses")
    public ResponseEntity<List<QuestionResponse>> getResponsesByQuestionId(@PathVariable Integer question_id){
        return ResponseEntity.ok(service.GetResponsesByQuestionId(question_id));
    }
}
