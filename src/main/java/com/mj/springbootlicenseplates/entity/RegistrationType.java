package com.mj.springbootlicenseplates.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "registration_types")
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_type_id")
    private Long registrationTypeId;

    private String type;
}
