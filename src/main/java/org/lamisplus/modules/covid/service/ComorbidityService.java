package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import org.lamisplus.modules.covid.domain.entity.Comorbidity;
import org.lamisplus.modules.covid.domain.entity.Vaccine;
import org.lamisplus.modules.covid.repository.ComorbidityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComorbidityService {
    @Autowired
    private ComorbidityRepository repository;

    public List<Comorbidity> GetAllComorbidities() {
        return repository.findAll();
    }
}
