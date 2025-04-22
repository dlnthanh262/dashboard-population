package com.example.dashboardpopulation.service;

import com.example.dashboardpopulation.model.Population;
import com.example.dashboardpopulation.repository.PopulationRepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class PopulationService {

    @Autowired
    private PopulationRepository populationRepository;

    public void importCsvData(String filePath) throws IOException, CsvException {
        CSVReader reader = new CSVReader(new FileReader(filePath));
        List<String[]> records = reader.readAll();
        List<Population> populations = new ArrayList<>();

        for (String[] record : records) {
            Population population = new Population();
            population.setCountryName(record[0]);
            population.setCountryCode(record[1]);
            population.setYear(Integer.parseInt(record[2]));
            population.setValue(Long.parseLong(record[3]));
            populations.add(population);
        }

        populationRepository.saveAll(populations);
    }
}