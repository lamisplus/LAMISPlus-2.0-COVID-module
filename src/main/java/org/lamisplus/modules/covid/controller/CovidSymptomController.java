package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.Symptom;
import org.lamisplus.modules.covid.service.PatientSymptomService;
import org.lamisplus.modules.covid.service.SymptomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/symptoms")
public class CovidSymptomController {
    private final SymptomService symptomService;

    @GetMapping("")
    public List<Symptom> getAllComorbidities(){
        return symptomService.GetAllSymptoms();
    }
}
