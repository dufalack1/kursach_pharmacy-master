package com.example.kursach.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "request")

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int number_request;
    private Date date_compilation;
    private Date date_shipment;
    private String status;
    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Invoice> invoices;

    private int pharmacy_id;
    private int employee_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pharmacy_id", insertable = false, updatable = false)
    private Pharmacies pharmacies;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

}
