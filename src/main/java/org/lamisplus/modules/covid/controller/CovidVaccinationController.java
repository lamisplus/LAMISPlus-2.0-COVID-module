package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.dto.PatientDTO;
import org.lamisplus.modules.covid.domain.dto.VaccinationDTO;
import org.lamisplus.modules.covid.service.VaccinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/covid")
public class CovidVaccinationController {
    private final VaccinationService service;

    @PostMapping("/vaccinations")
    public VaccinationDTO AddVaccination(@RequestBody VaccinationDTO vaccinationDTO){
        return service.Save(vaccinationDTO);
    }

    @PutMapping("/vaccinations/{id}")
    public VaccinationDTO UpdateVaccination(@PathVariable int id, @RequestBody VaccinationDTO vaccinationDTO){
        return service.Update(id, vaccinationDTO);
    }

    @GetMapping("/vaccinations/patients/{patientId}")
    public List<VaccinationDTO> GetVaccinationsByPatientId(@PathVariable long patientId){
        return service.GetAllVaccinationsByPatientId(patientId);
    }

    @GetMapping("/vaccinations/{id}")
    public VaccinationDTO GetVaccinationById(@PathVariable long id){
        return service.GetVaccinationById(id);
    }

    @DeleteMapping("/vaccinations/{id}")
    public String DeleteVaccination(@PathVariable Integer id){
        return service.Delete(id);
    }
}
