package com.example.kursach.repository;

import com.example.kursach.entity.Pharmacies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.relational.core.sql.In;

public interface PharmaciesRepository extends JpaRepository<Pharmacies, Integer> {
}
