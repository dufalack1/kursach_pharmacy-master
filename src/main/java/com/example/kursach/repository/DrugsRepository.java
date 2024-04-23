package com.example.kursach.repository;

import com.example.kursach.entity.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugsRepository extends JpaRepository<Drugs, Integer> {
}
