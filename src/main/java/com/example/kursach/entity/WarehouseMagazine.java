package com.example.kursach.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "warehouse_magazine")

public class WarehouseMagazine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date_recipt;
    private int price;
    private Date expiration_date;
    private int quantity_primary_pack;

    private int drugs_id;
    private int employee_id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugs_id", insertable = false, updatable = false)
    private Drugs drugs;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

}
