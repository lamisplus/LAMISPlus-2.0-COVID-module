package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.Symptom;
import org.lamisplus.modules.covid.domain.entity.PatientSymptom;
import org.lamisplus.modules.covid.service.SymptomService;
import org.lamisplus.modules.covid.service.PatientSymptomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/patientsymptoms")
public class CovidPatientSymptomController {
    private final PatientSymptomService patientSymptomService;

    @PostMapping("")
    public List<PatientSymptom> SavePatientComorbidities(@RequestBody List<PatientSymptom> symptoms){
        return patientSymptomService.SaveAll(symptoms);
    }

    @PutMapping("/{id}")
    public PatientSymptom UpdatePatientSymptom(@PathVariable Long id, @RequestBody PatientSymptom symptom){
        return patientSymptomService.UpdateSymptom(symptom);
    }

    @GetMapping("/{patient_id}")
    public List<PatientSymptom> getPatientComorbidities(@PathVariable Integer patient_id){
        return patientSymptomService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/{id}")
    public String DeletePatientSymptom(@PathVariable Integer id){
        return patientSymptomService.DeleteSymptom(id);
    }
}

