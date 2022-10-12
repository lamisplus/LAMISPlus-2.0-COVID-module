package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.VaccinationDoseDTO;
import org.lamisplus.modules.covid.domain.entity.VaccinationDose;
import org.lamisplus.modules.covid.domain.mapper.CovidMapper;
import org.lamisplus.modules.covid.repository.VaccinationDoseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class VaccinationDoseService {
    private final VaccinationDoseRepository repository;
    private final CovidMapper mapper;

    public VaccinationDoseDTO Save(VaccinationDoseDTO vaccinationDoseDTO){
        VaccinationDose vaccinationDose = mapper.toVaccinationDose(vaccinationDoseDTO);
        return mapper.toVaccinationDoseDto(repository.save(vaccinationDose));
    }

    public VaccinationDoseDTO Update(int id, VaccinationDoseDTO vaccinationDoseDTO){
        VaccinationDose vaccinationDose = mapper.toVaccinationDose(vaccinationDoseDTO);
        return mapper.toVaccinationDoseDto(repository.save(vaccinationDose));
    }

    public VaccinationDoseDTO GetVaccinationDoseById(Long id){
        return mapper.toVaccinationDoseDto(repository.findById(id).orElse(null));
    }

    public List<VaccinationDoseDTO> GetAllVaccinationDosesByVaccinationId(Long vaccinationId) {
        return mapper.toVaccinationDoseDtoList(repository.findVaccinationDosesByVaccinationId(vaccinationId));
    }

    public String Delete(Long id) {
        VaccinationDose vaccinationDose = repository.findById(id).orElse(null);
        assert vaccinationDose != null;
        repository.delete(vaccinationDose);
        return id + " deleted successfully";
    }
}
