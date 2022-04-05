package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.PatientStatus;
import org.lamisplus.modules.covid.service.PatientStatusService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/patientstatus")
public class CovidPatientStatusController {
    private final PatientStatusService service;

    @PostMapping("")
    public PatientStatus AddStatus(@RequestBody PatientStatus patientStatus){
        return service.SaveStatus(patientStatus);
    }

    @PutMapping("/{id}")
    public PatientStatus UpdateStatus(@PathVariable Long id, @RequestBody PatientStatus patientStatus){
        return service.UpdateStatus(patientStatus);
    }

    @GetMapping("")
    public PatientStatus getStatus(@PathVariable Long id){
        return service.GetbyPatientId(id);
    }

    @DeleteMapping("/{id}")
    public String DeletePatient(@PathVariable Integer id){
        return service.DeleteStatus(id);
    }
}
