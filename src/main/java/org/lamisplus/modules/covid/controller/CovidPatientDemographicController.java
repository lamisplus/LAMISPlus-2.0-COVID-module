package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.Demographic;
import org.lamisplus.modules.covid.service.DemographicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/patientdemographics")
public class CovidPatientDemographicController {
    private final DemographicService service;

    @PostMapping("/")
    public Demographic Add(@RequestBody Demographic demographic){
        return service.SaveDemographic(demographic);
    }

    @PutMapping("/{id}")
    public Demographic Update(@PathVariable Long id, @RequestBody Demographic demographic){
        return service.UpdateDemographic(demographic);
    }

    @GetMapping("")
    public List<Demographic> LoadDemographics(@PathVariable int patient_id){
        return service.GetDemographics(patient_id);
    }

    @DeleteMapping("/{id}")
    public String Delete(@PathVariable Integer id){
        return service.DeleteDemographic(id);
    }
}
