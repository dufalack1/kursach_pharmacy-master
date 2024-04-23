package com.example.kursach.repository;

import com.example.kursach.entity.WarehouseMagazine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface WarehouseRepository extends JpaRepository<WarehouseMagazine, Integer> {
}
