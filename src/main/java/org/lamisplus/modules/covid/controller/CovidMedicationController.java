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
@RequestMapping("api/covid/medications")
public class CovidMedicationController {
    private final MedicationService medicationService;
    private final PatientMedicationService patientMedicationService;

    @GetMapping("/list")
    public List<Medication> getAllMedications(){
        return medicationService.GetAllMedications();
    }

    @PostMapping("/save")
    public PatientMedication SavePatientMedication(@RequestBody PatientMedication medication){
        return patientMedicationService.SaveMedication(medication);
    }

    @PostMapping("/saveall")
    public List<PatientMedication> SavePatientMedications(@RequestBody List<PatientMedication> medications){
        return patientMedicationService.SaveAll(medications);
    }

    @PostMapping("/update")
    public PatientMedication UpdatePatientMedication(@RequestBody PatientMedication medication){
        return patientMedicationService.UpdateMedication(medication);
    }

    @GetMapping("/{patient_id}")
    public List<PatientMedication> getPatientMedications(@PathVariable Integer patient_id){
        return patientMedicationService.GetbyPatientId(patient_id);
    }

    @DeleteMapping("/delete/{id}")
    public String DeletePatientMedication(@PathVariable Integer id){
        return patientMedicationService.DeleteMedication(id);
    }
}
