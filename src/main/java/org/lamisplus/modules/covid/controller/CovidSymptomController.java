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
@RequestMapping("api/covid/symptoms")
public class CovidSymptomController {
    private final SymptomService symptomService;
    private final PatientSymptomService patientSymptomService;

    @GetMapping("/list")
    public List<Symptom> getAllComorbidities(){
        return symptomService.GetAllSymptoms();
    }

    @PostMapping("/save")
    public PatientSymptom SavePatientSymptom(@RequestBody PatientSymptom symptom){
        return patientSymptomService.SaveSymptom(symptom);
    }

    @PostMapping("/saveall")
    public List<PatientSymptom> SavePatientComorbidities(@RequestBody List<PatientSymptom> symptoms){
        return patientSymptomService.SaveAll(symptoms);
    }

    @PostMapping("/update")
    public PatientSymptom UpdatePatientSymptom(@RequestBody PatientSymptom symptom){
        return patientSymptomService.UpdateSymptom(symptom);
    }

    @GetMapping("/{patient_id}")
    public List<PatientSymptom> getPatientComorbidities(@PathVariable Integer patient_id){
        return patientSymptomService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/delete/{id}")
    public String DeletePatientSymptom(@PathVariable Integer id){
        return patientSymptomService.DeleteSymptom(id);
    }
}

