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
@Table(name = "covid_demographic")
public class Demographic {
    @Id
    @GeneratedValue
    private int id;
    private String uuid;
    private int sex;
    private Date dob;
    private int preterm;
    private int low_birth_weight;
    private float weight;
    private int race;
    private int hw_in_contact;
    private int pregnant_current;
    private int pregnant_within_21;
    private int pregnant_within_42;
}
