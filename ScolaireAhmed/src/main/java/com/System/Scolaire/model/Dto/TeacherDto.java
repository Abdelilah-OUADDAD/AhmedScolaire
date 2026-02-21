package com.System.Scolaire.model.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {

    private Integer teacherId;

    @NotBlank(message = "Nom obligatoire!")
    private String nom;

    @NotBlank(message = "Prénom obligatoire!")
    private String prenom;

    @NotBlank(message = "Address obligatoire!")
    private String address;
    private Integer specialiteId;

    // Info from Specialite relation
    private String NomSpecialite;

    private String specialiteDescription;

    // Full name method
    public String getNomComplet() {
        return prenom + " " + nom;
    }
}