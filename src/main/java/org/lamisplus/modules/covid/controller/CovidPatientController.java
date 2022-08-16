package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.PatientDTO;
import org.lamisplus.modules.covid.domain.dto.PatientStatusDTO;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.lamisplus.modules.covid.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/covid")
public class CovidPatientController {
    private final PatientService service;

    @PostMapping("/patients")
    public PatientDTO AddPatient(@RequestBody PatientDTO patient){
        return service.SavePatient(patient);
    }

    @PutMapping("/patients/{id}")
    public PatientDTO UpdatePatient(@PathVariable int id, @RequestBody PatientDTO patient){
        return service.UpdatePatient(id, patient);
    }

    @GetMapping("/patients")
    public List<PatientDTO> GetPatients(){
        return service.GetAllPatients();
    }

    @DeleteMapping("/patients/{id}")
    public String DeletePatient(@PathVariable Integer id){
        return service.DeletePatient(id);
    }

    @PostMapping("/patientstatus")
    public PatientStatusDTO SaveCurrentStatus(@RequestBody PatientStatusDTO patientStatus){
        return service.SaveStatus(patientStatus);
    }

    @GetMapping("/patientstatus/{patient_id}")
    public PatientStatusDTO GetCurrentStatus(@PathVariable Integer patient_id){
        return service.GetStatusByPatientId(patient_id);
    }

    @DeleteMapping("/patientstatus/{patient_id}")
    public String DeleteCurrentStatus(@PathVariable Integer patient_id){
        return service.DeleteStatus(patient_id);
    }

}
