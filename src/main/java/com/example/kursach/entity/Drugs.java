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
@Table(name = "drugs")
public class Drugs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String commercy_name;
    private String mnn_name;
    private String country;
    private String release_form;
    private int quntity_in_primary_pack;

    @OneToMany(mappedBy = "drugs", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<WarehouseMagazine> warehouseMagazines;
}
