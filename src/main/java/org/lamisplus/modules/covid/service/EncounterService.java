package org.lamisplus.modules.covid.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.EncounterDTO;
import org.lamisplus.modules.covid.domain.entity.Encounter;
import org.lamisplus.modules.covid.domain.mapper.CovidMapper;
import org.lamisplus.modules.covid.repository.EncounterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class EncounterService {
    private final EncounterRepository repository;
    private final CovidMapper mapper;

    public EncounterDTO Save(EncounterDTO encounterDTO){
        Encounter encounter = mapper.toEncounter(encounterDTO);
        return mapper.toEncounterDto(repository.save(encounter));
    }

    public EncounterDTO Update(int id, EncounterDTO encounterDTO){
        Encounter encounter = mapper.toEncounter(encounterDTO);
        return mapper.toEncounterDto(repository.save(encounter));
    }

    public List<EncounterDTO> GetAllEncountersByPatientId(int patientId, String category) {
        return mapper.toEncounterDtoList(repository.findEncountersByPatientIdAndCategory(patientId, category));
    }

    public String Delete(int id) {
        Encounter encounter = repository.findById(id).orElse(null);
        repository.delete(encounter);
        return id + " deleted successfully";
    }
}
