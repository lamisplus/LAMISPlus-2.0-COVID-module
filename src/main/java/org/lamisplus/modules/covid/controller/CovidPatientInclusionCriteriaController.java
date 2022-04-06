package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.InclusionCriteria;
import org.lamisplus.modules.covid.domain.entity.PatientStatus;
import org.lamisplus.modules.covid.service.InclusionCriteriaService;
import org.lamisplus.modules.covid.service.PatientStatusService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/inclusioncriteria")
public class CovidPatientInclusionCriteriaController {
    private final InclusionCriteriaService service;

    @PostMapping("")
    public InclusionCriteria Add(@RequestBody InclusionCriteria criteria){
        return service.Save(criteria);
    }

    @PutMapping("/{id}")
    public InclusionCriteria Update(@PathVariable int id, @RequestBody InclusionCriteria criteria){
        return service.Update(id, criteria);
    }

    @GetMapping("")
    public InclusionCriteria load(@PathVariable int id){
        return service.load(id);
    }

    @DeleteMapping("/{id}")
    public String Delete(@PathVariable Integer id){
        return service.Delete(id);
    }
}
