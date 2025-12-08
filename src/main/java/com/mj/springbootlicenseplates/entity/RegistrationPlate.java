package com.mj.springbootlicenseplates.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "registration_plates")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistrationPlate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_plate_id")
    private Long registrationPlateId;

    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private RegistrationType type;

 /*   @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "registration_plate_fun_fact",
            joinColumns = @JoinColumn(name = "registration_plate_id"),
            inverseJoinColumns = @JoinColumn(name = "fun_fact_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<FunFact> funFacts;*/

    @Column(name = "number_of_views")
    private Long numberOfViews;
}

