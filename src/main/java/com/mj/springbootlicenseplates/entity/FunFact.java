package com.mj.springbootlicenseplates.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Table(name = "fun_facts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FunFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fun_fact_id")
    private Long funFactId;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToMany(mappedBy = "funFacts")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<RegistrationPlate> registrationPlates;

    private String source;
}
