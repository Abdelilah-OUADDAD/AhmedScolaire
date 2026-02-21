package com.System.Scolaire.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Specialite")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SpecialiteID")
    private Integer specialiteId;

    @Column(name = "NomSpecialite", length = 100)
    private String nomSpecialite;

    @Column(name = "Description", length = 255)
    private String description;
}