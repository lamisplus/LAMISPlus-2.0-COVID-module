package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.VaccinationDTO;
import org.lamisplus.modules.covid.domain.entity.Vaccination;
import org.lamisplus.modules.covid.domain.mapper.CovidMapper;
import org.lamisplus.modules.covid.repository.VaccinationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class VaccinationService {
    private final VaccinationRepository repository;
    private final CovidMapper mapper;

    public VaccinationDTO Save(VaccinationDTO vaccinationDTO){
        Vaccination vaccination = mapper.toVaccination(vaccinationDTO);
        return mapper.toVaccinationDto(repository.save(vaccination));
    }

    public VaccinationDTO Update(int id, VaccinationDTO vaccinationDTO){
        Vaccination vaccination = mapper.toVaccination(vaccinationDTO);
        return mapper.toVaccinationDto(repository.save(vaccination));
    }

    public VaccinationDTO GetVaccinationById(Long id){
        return mapper.toVaccinationDto(repository.findById(id).orElse(null));
    }

    public List<VaccinationDTO> GetAllVaccinationsByPatientId(Long patientId) {
        return mapper.toVaccinationDtoList(repository.findVaccinationsByPatientId(patientId));
    }

    public String Delete(long id) {
        Vaccination vaccination = repository.findById(id).orElse(null);
        assert vaccination != null;
        repository.delete(vaccination);
        return id + " deleted successfully";
    }
}
