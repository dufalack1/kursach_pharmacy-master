package com.example.kursach.service;

import com.example.kursach.entity.WarehouseMagazine;
import com.example.kursach.repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;

    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<WarehouseMagazine> getAllWM()
    {
        List<WarehouseMagazine> warehouseMagazines = new ArrayList<WarehouseMagazine>();
        warehouseRepository.findAll().forEach(warehouseMagazine1 -> warehouseMagazines.add(warehouseMagazine1));
        return warehouseMagazines;
    }

    public WarehouseMagazine getWMById(int id)
    {
        return warehouseRepository.findById(id).get();
    }
    public void saveOrUpdate(WarehouseMagazine warehouseMagazine)
    {
        warehouseRepository.save(warehouseMagazine);
    }
    public void delete(int id)
    {
        warehouseRepository.deleteById(id);
    }
    public void update(WarehouseMagazine warehouseMagazine, int id)
    {
        warehouseRepository.save(warehouseMagazine);
    }
}
