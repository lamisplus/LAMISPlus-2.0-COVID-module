package org.lamisplus.modules.covid.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "covid_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "uuid")
    private String uuid;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "mid_name")
    private String midName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "participant_id")
    private String participantId;
    @Column(name = "gender")
    private int gender;
    @Column(name = "dob")
    private LocalDate dob;
    @Column(name = "phone")
    private String phone;
    @Column(name = "current_status")
    private String currentStatus;
    @Column(name = "vaccination_status")
    private String vaccinationStatus;
    @Column(name = "address")
    private String address;
}
