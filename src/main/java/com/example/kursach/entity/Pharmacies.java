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
@Table(name = "pharmacy")

public class Pharmacies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String address;
    private String name;
    private String FIO_director;
    private int phone;


    @OneToMany(mappedBy = "pharmacies", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Request> requests;

}
