package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.PatientVitalsign;
import org.lamisplus.modules.covid.service.PatientVitalsignService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/patientvitalsigns")
public class CovidPatientVitalsignController {
    private final PatientVitalsignService patientVitalsignService;

    @PostMapping("")
    public PatientVitalsign SavePatientVitalsign(@RequestBody PatientVitalsign vitalsign){
        return patientVitalsignService.SaveVitalsign(vitalsign);
    }

    @PutMapping("/{id}")
    public PatientVitalsign UpdatePatientVitalsign(@PathVariable Long id, @RequestBody PatientVitalsign vitalsign){
        return patientVitalsignService.UpdateVitalsign(vitalsign);
    }

    @GetMapping("/{patient_id}")
    public List<PatientVitalsign> getPatientVitalsigns(@PathVariable Integer patient_id){
        return patientVitalsignService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/{id}")
    public String DeletePatientVitalsign(@PathVariable Integer id){
        return patientVitalsignService.DeleteVitalsign(id);
    }
}

