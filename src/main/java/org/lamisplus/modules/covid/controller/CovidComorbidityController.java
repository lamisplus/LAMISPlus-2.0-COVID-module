package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.Comorbidity;
import org.lamisplus.modules.covid.service.ComorbidityService;
import org.lamisplus.modules.covid.service.PatientComorbidityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/comorbidities")
public class CovidComorbidityController {
    private final ComorbidityService comorbidityService;

    @GetMapping("")
    public List<Comorbidity> getAllComorbidities(){
        return comorbidityService.GetAllComorbidities();
    }
}
