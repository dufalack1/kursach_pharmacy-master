package com.example.kursach.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date_compilation;
    private int id_request;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_request", insertable = false, updatable = false)
    private Request request;
}
