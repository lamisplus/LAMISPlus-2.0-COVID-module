package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.PatientReinfection;
import org.lamisplus.modules.covid.service.PatientReinfectionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/reinfections")
public class CovidReinfectionController {
    private final PatientReinfectionService patientReinfectionService;
    
    @PostMapping("/save")
    public PatientReinfection SavePatientReinfection(@RequestBody PatientReinfection reinfection){
        return patientReinfectionService.SaveReinfection(reinfection);
    }

    @PostMapping("/update")
    public PatientReinfection UpdatePatientReinfection(@RequestBody PatientReinfection reinfection){
        return patientReinfectionService.UpdateReinfection(reinfection);
    }

    @GetMapping("/{patient_id}")
    public List<PatientReinfection> getPatientReinfections(@PathVariable Integer patient_id){
        return patientReinfectionService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/delete/{id}")
    public String DeletePatientReinfection(@PathVariable Integer id){
        return patientReinfectionService.DeleteReinfection(id);
    }
}

