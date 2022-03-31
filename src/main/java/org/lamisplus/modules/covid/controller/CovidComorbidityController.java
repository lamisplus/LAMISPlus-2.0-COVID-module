package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.Comorbidity;
import org.lamisplus.modules.covid.domain.entity.PatientComorbidity;
import org.lamisplus.modules.covid.service.ComorbidityService;
import org.lamisplus.modules.covid.service.PatientComorbidityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/comorbidities")
public class CovidComorbidityController {
    private final ComorbidityService comorbidityService;
    private final PatientComorbidityService patientComorbidityService;

    @GetMapping("/list")
    public List<Comorbidity> getAllComorbidities(){
        return comorbidityService.GetAllComorbidities();
    }

    @PostMapping("/save")
    public PatientComorbidity SavePatientComorbidity(@RequestBody PatientComorbidity comorbidity){
        return patientComorbidityService.SaveComorbidity(comorbidity);
    }

    @PostMapping("/saveall")
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
