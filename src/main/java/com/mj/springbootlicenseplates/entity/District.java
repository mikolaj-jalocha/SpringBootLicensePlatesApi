package com.mj.springbootlicenseplates.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "districts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "district_id")
    private Long districtId;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "voivodeship_id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Voivodeship voivodeship;
}
