package org.lamisplus.modules.covid.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VaccinationDoseDTO {
    private long id;
    private String doseNumber;
    private int vaccine;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime vaccineDate;
    private int location;
    private String vaccinationFacility;
    private String batchNumber;
    private String adverseEffect;
    private long vaccinationId;
}
