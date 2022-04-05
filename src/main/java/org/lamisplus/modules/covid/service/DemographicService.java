package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Demographic;
import org.lamisplus.modules.covid.repository.DemographicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DemographicService {
    @Autowired
    private DemographicRepository repository;

    public Demographic SaveDemographic(Demographic demographic){
        return repository.save(demographic);
    }

    public Demographic UpdateDemographic(int id, Demographic demographic){
        return repository.save(demographic);
    }

    public List<Demographic> GetDemographics(int PatientId) {
        return repository.findAllByPatientId(PatientId);
    }

    public String DeleteDemographic(int id) {
        return repository.delete(id);
    }
}
