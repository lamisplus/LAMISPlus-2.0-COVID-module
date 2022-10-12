package org.lamisplus.modules.covid.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class VaccinationDTO {
    private long id;
    private long patientId;
    private Long visitId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime visitDate;
    private int workInHealthSector;
    private int occupation;
    private int knownMedicalCondition;
    private int medicalCondition;
    private int acceptVaccination;
    private String vaccineId;
    private List<VaccinationDoseDTO> vaccinationDoses;
}
