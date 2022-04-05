package org.lamisplus.modules.covid.service;

import org.lamisplus.modules.covid.domain.entity.Demographic;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.lamisplus.modules.covid.repository.DemographicRepository;
import org.lamisplus.modules.covid.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DemographicService {
    @Autowired
    private DemographicRepository repository;

    public Demographic SaveDemographic(Demographic demographic){
        return repository.save(demographic);
    }

    public Demographic UpdateDemographic(Demographic demographic){
        return repository.save(demographic);
    }

    public List<Demographic> GetDemographic(Long PatientId) {
        return repository.findAll();
    }

    public String DeleteDemographic(int id) {
        return repository.delete(id);
    }
}
