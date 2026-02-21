package com.System.Scolaire.Mapper;

import com.System.Scolaire.model.Dto.TeacherDto;
import com.System.Scolaire.model.entity.Teacher;
import com.System.Scolaire.model.entity.Specialite;
import com.System.Scolaire.repository.SpecialiteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherComponent {

    @Autowired
    private SpecialiteRepo specialiteRepo;

    // Convert Entity -> DTO
    public TeacherDto toDto(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        TeacherDto dto = new TeacherDto();
        dto.setTeacherId(teacher.getTeacherId());
        dto.setNom(teacher.getNom());
        dto.setPrenom(teacher.getPrenom());
        dto.setAddress(teacher.getAddress());

        // Get info from Specialite relation
        if (teacher.getSpecialite() != null) {
            dto.setSpecialiteId(teacher.getSpecialite().getSpecialiteId());
            dto.setNomSpecialite((teacher.getSpecialite().getNomSpecialite()));
            dto.setSpecialiteDescription(teacher.getSpecialite().getDescription());
        }

        return dto;
    }

    // Convert DTO -> Entity
    public Teacher toEntity(TeacherDto dto) {
        if (dto == null) {
            return null;
        }

        Teacher teacher = new Teacher();
        teacher.setTeacherId(dto.getTeacherId());
        teacher.setNom(dto.getNom());
        teacher.setPrenom(dto.getPrenom());
        teacher.setAddress(dto.getAddress());

        // Set Specialite relation from ID
        if (dto.getSpecialiteId() != null) {
            Specialite specialite = specialiteRepo.findById(dto.getSpecialiteId()).orElse(null);
            teacher.setSpecialite(specialite);
        }

        return teacher;
    }
}