package org.lamisplus.modules.covid.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;

@Data
public class PatientDTO {
    private int id;
    private String firstName;
    private String midName;
    private String lastName;
    private String participantId;
    private int gender;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dob;
    private String phone;
    private String currentStatus;
    private String vaccinationStatus;
    private String address;
}
