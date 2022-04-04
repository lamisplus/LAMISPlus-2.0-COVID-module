package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.Medication;
import org.lamisplus.modules.covid.service.MedicationService;
import org.lamisplus.modules.covid.service.PatientMedicationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/medications")
public class CovidMedicationController {
    private final MedicationService medicationService;

    @GetMapping("")
    public List<Medication> getAllMedications(){
        return medicationService.GetAllMedications();
    }
}
