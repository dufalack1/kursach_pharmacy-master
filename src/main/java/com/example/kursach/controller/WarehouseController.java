package com.example.kursach.controller;

import com.example.kursach.entity.WarehouseMagazine;
import com.example.kursach.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;
    @GetMapping("/wm")
    private List<WarehouseMagazine> getAllWM()
    {
        return warehouseService.getAllWM();
    }
    @GetMapping("/wm/{id}")
    private WarehouseMagazine getWMById(@PathVariable("id") int id)
    {
        return warehouseService.getWMById(id);
    }
    @DeleteMapping("/wm/{id}")
    private void deleteWM(@PathVariable("id") int id)
    {
        warehouseService.delete(id);
    }
    @PostMapping("/wm")
    private int saveWM(@RequestBody WarehouseMagazine warehouseMagazine)
    {
        warehouseService.saveOrUpdate(warehouseMagazine);
        return warehouseMagazine.getId();
    }
    @PutMapping("/wm")
    private WarehouseMagazine update(@RequestBody WarehouseMagazine warehouseMagazine)
    {
        warehouseService.saveOrUpdate(warehouseMagazine);
        return warehouseMagazine;
    }
}
