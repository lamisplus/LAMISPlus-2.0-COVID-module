package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.PatientVaccine;
import org.lamisplus.modules.covid.service.PatientVaccineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/patientvaccination")
public class CovidPatientVaccinationController {
    private final PatientVaccineService patientVaccineService;

    @PostMapping("")
    public List<PatientVaccine> Save(@RequestBody List<PatientVaccine> vaccines){
        return patientVaccineService.SaveAll(vaccines);
    }

    @PutMapping("/{id}")
    public PatientVaccine Update(@PathVariable int id, @RequestBody PatientVaccine vaccine){
        return patientVaccineService.UpdateVaccine(id, vaccine);
    }

    @GetMapping("/{patient_id}")
    public List<PatientVaccine> getVaccinationDetails(@PathVariable Integer patient_id){
        return patientVaccineService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/{id}")
    public String DeleteVaccination(@PathVariable Integer id){
        return patientVaccineService.DeleteVaccine(id);
    }
}
