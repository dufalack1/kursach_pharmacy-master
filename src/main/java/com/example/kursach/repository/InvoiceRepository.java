package com.example.kursach.repository;

import com.example.kursach.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
