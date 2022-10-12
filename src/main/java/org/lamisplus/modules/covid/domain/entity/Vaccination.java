package org.lamisplus.modules.covid.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "covid_vaccination")
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "patient_id")
    private long patientId;
    @Column(name = "patient_uuid")
    private long patientUuid;
    @Column(name = "facility_id")
    private int facilityId;
    @Column(name = "facility_uuid")
    private String facilityUuid;
    @Column(name = "visit_id")
    private Long visitId;
    @Column(name = "visit_date")
    private LocalDateTime visitDate;
    @Column(name = "work_in_health_sector")
    private int workInHealthSector;
    @Column(name = "occupation")
    private int occupation;
    @Column(name = "known_medical_condition")
    private int knownMedicalCondition;
    @Column(name = "medical_condition")
    private int medicalCondition;
    @Column(name = "accept_vaccination")
    private int acceptVaccination;
    @Column(name = "vaccine_id")
    private String vaccineId;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @Column(name = "updated_by")
    private int updatedBy;

    @JoinColumn(name = "vaccination_id")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VaccinationDose> vaccinationDoses;
}
