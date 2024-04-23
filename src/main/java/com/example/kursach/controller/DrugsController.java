package com.example.kursach.controller;

import com.example.kursach.entity.Drugs;
import com.example.kursach.service.DrugsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrugsController {
    @Autowired
    DrugsService drugsService;
    @GetMapping("/drugs")
    private List<Drugs> getAllDrugs()
    {
        return drugsService.getAllDrugs();
    }
    @GetMapping("/drugs/{id}")
    private Drugs getDrugs(@PathVariable("id") int id)
    {
        return drugsService.getDrugsById(id);
    }
    @DeleteMapping("/drugs/{id}")
    private void deleteDrugs(@PathVariable("id") int id)
    {
        drugsService.delete(id);
    }
    @PostMapping("/drugs")
    private int saveDrugs(@RequestBody Drugs drugs)
    {
        drugsService.save(drugs);
        return drugs.getId();
    }
    @PutMapping("/drugs")
    private Drugs update(@RequestBody Drugs drugs)
    {
        drugsService.update(drugs);
        return drugs;
    }
}
