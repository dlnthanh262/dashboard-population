package com.example.dashboardpopulation.config;

import com.example.dashboardpopulation.model.Population;
import com.example.dashboardpopulation.repository.PopulationRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final PopulationRepository populationRepository;

    @Autowired
    public DataInitializer(PopulationRepository populationRepository) {
        this.populationRepository = populationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (populationRepository.count() == 0) {
            InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("data/population.csv");
            if (inputStream == null) {
                System.out.println("population.csv not found in resources/data/");
                return;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                 CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {

                List<String[]> records = csvReader.readAll();
                List<Population> populations = new ArrayList<>();

                for (String[] row : records) {
                    Population population = new Population();
                    population.setCountryName(row[0]);
                    population.setCountryCode(row[1]);
                    population.setYear(Short.parseShort(row[2]));
                    population.setValue((long) Double.parseDouble(row[3]));
                    populations.add(population);
                }

                populationRepository.saveAll(populations);
                System.out.println("population.csv imported successfully.");
            }
        } else {
            System.out.println("Data already exists. Skipping import.");
        }
    }
}