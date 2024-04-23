package com.example.kursach.service;

import com.example.kursach.entity.Pharmacies;
import com.example.kursach.repository.PharmaciesRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PharmaciesService {
    private final PharmaciesRepository pharmaciesRepository;

    public PharmaciesService(PharmaciesRepository pharmaciesRepository) {
        this.pharmaciesRepository = pharmaciesRepository;
    }

    public List<Pharmacies> getAllPharmacies()
    {
        List<Pharmacies> pharmacies = new ArrayList<Pharmacies>();
        pharmaciesRepository.findAll().forEach(pharmacies1 -> pharmacies.add(pharmacies1));
        return pharmacies;
    }

    public Pharmacies getPharmaciesById(int id)
    {
        return pharmaciesRepository.findById(id).get();
    }
    public void saveOrUpdate(Pharmacies pharmacies)
    {
        pharmaciesRepository.save(pharmacies);
    }
    public void delete(int id)
    {
        pharmaciesRepository.deleteById(id);
    }
    public void update(Pharmacies pharmacies, int id)
    {
        pharmaciesRepository.save(pharmacies);
    }

}
