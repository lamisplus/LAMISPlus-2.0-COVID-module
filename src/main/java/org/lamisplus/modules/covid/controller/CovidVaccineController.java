package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.PatientVaccine;
import org.lamisplus.modules.covid.domain.entity.Vaccine;
import org.lamisplus.modules.covid.domain.entity.Vaccine;
import org.lamisplus.modules.covid.service.PatientVaccineService;
import org.lamisplus.modules.covid.service.VaccineService;
import org.lamisplus.modules.covid.service.VaccineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/vaccines")
public class CovidVaccineController {
    private final VaccineService vaccineService;
    private final PatientVaccineService patientVaccineService;

    @GetMapping("/list")
    public List<Vaccine> getAllVaccines(){
        return vaccineService.GetAllVaccines();
    }

    @PostMapping("/save")
    public PatientVaccine SavePatientVaccine(@RequestBody PatientVaccine vaccine){
        return patientVaccineService.SaveVaccine(vaccine);
    }

    @PostMapping("/saveall")
    public List<PatientVaccine> SavePatientVaccines(@RequestBody List<PatientVaccine> vaccines){
        return patientVaccineService.SaveAll(vaccines);
    }

    @PostMapping("/update")
    public PatientVaccine UpdatePatientVaccine(@RequestBody PatientVaccine vaccine){
        return patientVaccineService.UpdateVaccine(vaccine);
    }

    @GetMapping("/{patient_id}")
    public List<PatientVaccine> getPatientVaccines(@PathVariable Integer patient_id){
        return patientVaccineService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/delete/{id}")
    public String DeletePatientVaccine(@PathVariable Integer id){
        return patientVaccineService.DeleteVaccine(id);
    }
}
