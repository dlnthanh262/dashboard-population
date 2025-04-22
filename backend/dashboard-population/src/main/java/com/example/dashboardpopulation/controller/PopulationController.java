package com.example.dashboardpopulation.controller;

import com.example.dashboardpopulation.model.Population;
import com.example.dashboardpopulation.service.PopulationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/populations")
public class PopulationController {

    private final PopulationService populationService;

    public PopulationController(PopulationService populationService) {
        this.populationService = populationService;
    }

    @GetMapping
    public List<Population> getAll() {
        return populationService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Population> getById(@PathVariable Long id) {
        return populationService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Population create(@RequestBody Population population) {
        return populationService.save(population);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Population> update(@PathVariable Long id, @RequestBody Population updated) {
        return populationService.findById(id).map(p -> {
            p.setCountryName(updated.getCountryName());
            p.setCountryCode(updated.getCountryCode());
            p.setYear(updated.getYear());
            p.setValue(updated.getValue());
            return ResponseEntity.ok(populationService.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        return populationService.findById(id).map(p -> {
            populationService.deleteById(id);
            return ResponseEntity.noContent().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}