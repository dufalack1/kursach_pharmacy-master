package com.example.kursach.controller;

import com.example.kursach.entity.Pharmacies;
import com.example.kursach.service.PharmaciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class PharmaciesController {
    @Autowired
    PharmaciesService pharmaciesService;
    @GetMapping("/pharmacies")
    private List<Pharmacies> getAllPharmacies()
    {
        return pharmaciesService.getAllPharmacies();
    }
    @GetMapping("/pharmacies/{id}")
    private Pharmacies getPharmacyById(@PathVariable("id") int id)
    {
        return pharmaciesService.getPharmaciesById(id);
    }
    @DeleteMapping("/pharmacies/{id}")
    private void deletePharmacies(@PathVariable("id") int id)
    {
        pharmaciesService.delete(id);
    }
    @PostMapping("/pharmacies")
    private int savePharmacies(@RequestBody Pharmacies pharmacies)
    {
        pharmaciesService.saveOrUpdate(pharmacies);
        return pharmacies.getId();
    }
    @PutMapping("/pharmacies")
    private Pharmacies update(@RequestBody Pharmacies pharmacies)
    {
        pharmaciesService.saveOrUpdate(pharmacies);
        return pharmacies;
    }
}
