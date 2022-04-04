package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.Vaccine;
import org.lamisplus.modules.covid.service.PatientVaccineService;
import org.lamisplus.modules.covid.service.VaccineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/vaccines")
public class CovidVaccineController {
    private final VaccineService vaccineService;

    @GetMapping("")
    public List<Vaccine> getAllVaccines(){
        return vaccineService.GetAllVaccines();
    }
}
