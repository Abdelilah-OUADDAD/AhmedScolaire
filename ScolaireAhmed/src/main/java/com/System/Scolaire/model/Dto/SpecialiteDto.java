package com.System.Scolaire.model.Dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpecialiteDto {

    private Integer specialiteId;

    private String nomSpecialite;

    private String description;
}
