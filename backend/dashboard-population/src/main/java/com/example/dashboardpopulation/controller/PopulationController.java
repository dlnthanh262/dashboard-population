package com.example.dashboardpopulation.controller;

import com.example.dashboardpopulation.service.PopulationService;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/population")
public class PopulationController {

    @Autowired
    private PopulationService populationService;
}