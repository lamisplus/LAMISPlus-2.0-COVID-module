package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.InclusionCriteria;
import org.lamisplus.modules.covid.repository.InclusionCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InclusionCriteriaService {
    @Autowired
    private InclusionCriteriaRepository repository;

    public InclusionCriteria load(int patient_id){
        return repository.findByPatientId(patient_id);
    }

    public InclusionCriteria Save(InclusionCriteria criteria){
        return repository.save(criteria);
    }

    public InclusionCriteria Update(int id, InclusionCriteria criteria){
        return repository.save(criteria);
    }

    public String Delete(int id) {
        return repository.delete(id);
    }
}
