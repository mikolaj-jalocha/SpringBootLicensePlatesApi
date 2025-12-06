package com.mj.springbootlicenseplates.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "fun_facts")
@NoArgsConstructor
@AllArgsConstructor
public class FunFact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fun_fact_id")
    private Long funFactId;

    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    private String source;
}
