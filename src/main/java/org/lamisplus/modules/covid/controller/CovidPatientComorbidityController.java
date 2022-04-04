package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.PatientComorbidity;
import org.lamisplus.modules.covid.service.PatientComorbidityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/patientcomorbidities")
public class CovidPatientComorbidityController {
    private final PatientComorbidityService patientComorbidityService;

    @PostMapping("/save")
    public List<PatientComorbidity> SavePatientComorbidities(@RequestBody List<PatientComorbidity> comorbidities){
        return patientComorbidityService.SaveAll(comorbidities);
    }

    @PostMapping("/update")
    public PatientComorbidity UpdatePatientComorbidity(@RequestBody PatientComorbidity comorbidity){
        return patientComorbidityService.UpdateComorbidity(comorbidity);
    }

    @GetMapping("/{patient_id}")
    public List<PatientComorbidity> getPatientComorbidities(@PathVariable Integer patient_id){
        return patientComorbidityService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/delete/{id}")
    public String DeletePatientComorbidity(@PathVariable Integer id){
        return patientComorbidityService.DeleteComorbidity(id);
    }
}
