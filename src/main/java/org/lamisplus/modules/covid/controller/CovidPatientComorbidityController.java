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

    @PostMapping("/")
    public List<PatientComorbidity> save(@RequestBody List<PatientComorbidity> comorbidities){
        return patientComorbidityService.SaveAll(comorbidities);
    }

    @PutMapping("/{id}")
    public PatientComorbidity update(@PathVariable Long id, @RequestBody PatientComorbidity comorbidity){
        return patientComorbidityService.UpdateComorbidity(comorbidity);
    }

    @GetMapping("/{patient_id}")
    public List<PatientComorbidity> getPatientComorbidities(@PathVariable Integer patient_id){
        return patientComorbidityService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        return patientComorbidityService.DeleteComorbidity(id);
    }
}
