package org.lamisplus.modules.covid.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "covid_patient_medication_detail")
public class PatientMedicationDetail {
    @Id
    @GeneratedValue
    private int id;
    private String uuid;
    private int patient_id;
    private int patientmedication_id;
    private int drug_id;
}