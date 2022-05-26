package org.lamisplus.modules.covid.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "covid_patient_status")
public class PatientStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "patient_id")
    private int patientId;
    @Column(name = "current_status")
    private String currentStatus;
}
