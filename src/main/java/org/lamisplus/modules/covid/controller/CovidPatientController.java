package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.PatientDTO;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.lamisplus.modules.covid.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/patients")
public class CovidPatientController {
    private final PatientService service;

    @PostMapping("")
    public PatientDTO AddPatient(@RequestBody PatientDTO patient){
        return service.SavePatient(patient);
    }

    @PutMapping("/{id}")
    public PatientDTO UpdatePatient(@PathVariable int id, @RequestBody PatientDTO patient){
        return service.UpdatePatient(id, patient);
    }

    @GetMapping("")
    public List<PatientDTO> GetPatients(){
        return service.GetAllPatients();
    }

    @DeleteMapping("/{id}")
    public String DeletePatient(@PathVariable Integer id){
        return service.DeletePatient(id);
    }
}
