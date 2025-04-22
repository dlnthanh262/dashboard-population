package com.example.dashboardpopulation.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Population {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(name = "country_name", nullable = false)
    private String countryName;

    @Column(name = "country_code", nullable = false)
    private String countryCode;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private long value;
}