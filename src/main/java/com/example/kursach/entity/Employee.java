package com.example.kursach.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int phone;
    private String FIO;
    private String place;
    private String passport;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Request> requests;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<WarehouseMagazine> warehouseMagazines;
}
