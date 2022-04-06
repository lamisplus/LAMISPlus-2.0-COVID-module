package org.lamisplus.modules.covid.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "covid_patient_vitalsign")
public class PatientVitalsign {
    @Id
    @GeneratedValue
    private int id;
    private String uuid;
    private int patient_id;
    private int visit_date;
    private Date symptom_date;
    private Date admission_date;
    private int transfer_in;
    private float temp;
    private float heart_rate;
    private float resp_rate;
    private int bp_systolic;
    private int bp_diastolic;
    private float oxygen_sat;
    private int patient_oxygen;
    private int arm_circum;
    private float height;
    private float weight;
}
