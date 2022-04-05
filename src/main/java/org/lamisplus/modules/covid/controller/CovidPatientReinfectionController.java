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
@RequestMapping("api/covid/patientreinfections")
public class CovidPatientReinfectionController {
    private final PatientReinfectionService patientReinfectionService;
    
    @PostMapping("")
    public PatientReinfection SavePatientReinfection(@RequestBody PatientReinfection reinfection){
        return patientReinfectionService.Save(reinfection);
    }

    @PutMapping("/{id}")
    public PatientReinfection UpdatePatientReinfection(@PathVariable int id, @RequestBody PatientReinfection reinfection){
        return patientReinfectionService.UpdateReinfection(id, reinfection);
    }

    @GetMapping("/{patient_id}")
    public List<PatientReinfection> getPatientReinfections(@PathVariable Integer patient_id){
        return patientReinfectionService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/{id}")
    public String DeletePatientReinfection(@PathVariable Integer id){
        return patientReinfectionService.DeleteReinfection(id);
    }
}

