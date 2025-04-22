package com.example.dashboardpopulation.service;

import com.example.dashboardpopulation.repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PopulationService {

    @Autowired
    private PopulationRepository populationRepository;
}