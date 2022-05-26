package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.PatientStatusDTO;
import org.lamisplus.modules.covid.domain.entity.CodeSet;
import org.lamisplus.modules.covid.domain.entity.Patient;
import org.lamisplus.modules.covid.repository.CodeSetRepository;
import org.lamisplus.modules.covid.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CodeSetService {
    private final CodeSetRepository codeSetRepository;

    public List<CodeSet> GetVaccinationStatusCodeSet(){
        return codeSetRepository.findAllByCategory("VACCINATION_STATUS");
    }

    public List<CodeSet> GetCurrentStatusCodeSet(){
        return codeSetRepository.findAllByCategory("CURRENT_STATUS");
    }
}
