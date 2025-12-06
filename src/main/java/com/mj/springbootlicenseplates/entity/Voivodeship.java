package com.mj.springbootlicenseplates.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "voivodeships")
@NoArgsConstructor
@AllArgsConstructor
public class Voivodeship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "voivodeship_id")
    private Long voivodeshipId;

    private String name;
}
