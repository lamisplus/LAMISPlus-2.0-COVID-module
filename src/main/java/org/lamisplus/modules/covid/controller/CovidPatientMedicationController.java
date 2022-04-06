package org.lamisplus.modules.covid.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.lamisplus.modules.covid.domain.entity.Medication;
import org.lamisplus.modules.covid.domain.entity.PatientMedication;
import org.lamisplus.modules.covid.service.MedicationService;
import org.lamisplus.modules.covid.service.PatientMedicationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/covid/patientmedications")
public class CovidPatientMedicationController {
    private final PatientMedicationService patientMedicationService;

    @PostMapping("")
    public List<PatientMedication> SavePatientMedications(@RequestBody List<PatientMedication> medications){
        return patientMedicationService.Save(medications);
    }

    @PutMapping("/{id}")
    public PatientMedication UpdatePatientMedication(@PathVariable int id, @RequestBody PatientMedication medication){
        return patientMedicationService.Update(id, medication);
    }

    @GetMapping("/{patient_id}")
    public List<PatientMedication> getPatientMedications(@PathVariable Integer patient_id){
        return patientMedicationService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/{id}")
    public String DeletePatientMedication(@PathVariable Integer id){
        return patientMedicationService.Delete(id);
    }
}
