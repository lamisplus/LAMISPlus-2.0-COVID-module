package org.lamisplus.modules.covid.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "covid_vaccination_dose")
public class VaccinationDose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "dose_number")
    private String doseNumber;
    @Column(name = "vaccine")
    private int vaccine;
    @Column(name = "vaccine_date")
    private LocalDateTime vaccineDate;
    @Column(name = "location")
    private int location;
    @Column(name = "vaccination_facility")
    private String vaccinationFacility;
    @Column(name = "batch_number")
    private String batchNumber;
    @Column(name = "adverse_effect")
    private String adverseEffect;
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "created_by")
    private int createdBy;
    @Column(name = "update_date")
    private LocalDateTime updateDate;
    @Column(name = "updated_by")
    private int updatedBy;
    @Column(name = "vaccination_id")
    private long vaccinationId;
}
