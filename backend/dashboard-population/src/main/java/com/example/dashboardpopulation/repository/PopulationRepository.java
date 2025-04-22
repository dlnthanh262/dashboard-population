package com.example.dashboardpopulation.repository;

import com.example.dashboardpopulation.model.Population;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopulationRepository extends JpaRepository<Population, Long> {
}