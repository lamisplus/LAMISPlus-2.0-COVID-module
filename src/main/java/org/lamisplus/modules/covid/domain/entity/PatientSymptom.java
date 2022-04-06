package org.lamisplus.modules.covid.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "covid_patient_symptom")
public class PatientSymptom {
    @Id
    @GeneratedValue
    private int id;
    private String uuid;
    private int patient_id;
    private LocalDate visit_date;
    private int symptom_id;
    private int symptom_value;
}
