package com.example.dashboardpopulation.service;

import com.example.dashboardpopulation.model.Population;
import com.example.dashboardpopulation.repository.PopulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PopulationService {

    private final PopulationRepository populationRepository;

    public PopulationService(PopulationRepository repository) {
        this.populationRepository = repository;
    }

    public List<Population> findAll() {
        return populationRepository.findAll();
    }

    public Optional<Population> findById(Long id) {
        return populationRepository.findById(id);
    }

    public Population save(Population population) {
        return populationRepository.save(population);
    }

    public void deleteById(Long id) {
        populationRepository.deleteById(id);
    }
}