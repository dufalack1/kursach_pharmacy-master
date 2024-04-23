package com.example.kursach.repository;

import com.example.kursach.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Integer> {
}
