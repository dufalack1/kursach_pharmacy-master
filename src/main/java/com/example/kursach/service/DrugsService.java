package com.example.kursach.service;

import com.example.kursach.entity.Drugs;
import com.example.kursach.repository.DrugsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DrugsService {
    private final DrugsRepository drugsRepository;

    public DrugsService(DrugsRepository drugsRepository) {
        this.drugsRepository = drugsRepository;
    }

    public List<Drugs> getAllDrugs()
    {
        List<Drugs> drugs = new ArrayList<Drugs>();
        drugsRepository.findAll().forEach(drugs1 -> drugs.add(drugs1));
        return drugs;
    }

    public Drugs getDrugsById(int id)
    {
        return drugsRepository.findById(id).get();
    }
    public void save(Drugs drugs)
    {
        drugsRepository.save(drugs);
    }
    public void delete(int id)
    {
        drugsRepository.deleteById(id);
    }
    public void update(Drugs drugs)
    {
        drugsRepository.save(drugs);
    }

}

