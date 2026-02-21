package com.System.Scolaire.service;

import com.System.Scolaire.Mapper.TeacherComponent;
import com.System.Scolaire.model.Dto.TeacherDto;
import com.System.Scolaire.model.entity.Teacher;
import com.System.Scolaire.repository.TeacherRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService implements TeacherServiceInterface {

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private TeacherComponent teacherComponent;

    // Get all teachers
    public List<TeacherDto> getAllTeachers() {
        return teacherRepo.findAll().stream()
                .map(teacherComponent::toDto)
                .collect(Collectors.toList());
    }

    // Get teacher by ID
    public TeacherDto getTeacherById(Integer id) {
        Optional<Teacher> teacher = teacherRepo.findById(id);
        return teacher.map(teacherComponent::toDto).orElse(null);
    }

    // Get teachers by Specialite ID
    public List<TeacherDto> getTeachersBySpecialite(Integer specialiteId) {
        return teacherRepo.findTeachersBySpecialiteId(specialiteId).stream()
                .map(teacherComponent::toDto)
                .collect(Collectors.toList());
    }

    // Save teacher
    @Transactional
    public TeacherDto saveTeacher(TeacherDto dto) {
        Teacher teacher = teacherComponent.toEntity(dto);
        return teacherComponent.toDto(teacherRepo.save(teacher));
    }

    // Update teacher
    @Transactional
    public TeacherDto updateTeacher(TeacherDto dto) {
        Teacher teacher = teacherComponent.toEntity(dto);
        return teacherComponent.toDto(teacherRepo.save(teacher));
    }

    // Delete teacher
    @Transactional
    public void deleteTeacher(Integer id) {
        teacherRepo.deleteById(id);
    }

    // Get all with details (manual mapping)
    public List<TeacherDto> getAllTeachersWithDetails() {
        List<Teacher> teachers = teacherRepo.findAll();

        return teachers.stream().map(t -> {
            TeacherDto dto = new TeacherDto();
            dto.setTeacherId(t.getTeacherId());
            dto.setNom(t.getNom());
            dto.setPrenom(t.getPrenom());
            dto.setAddress(t.getAddress());

            if (t.getSpecialite() != null) {
                dto.setSpecialiteId(t.getSpecialite().getSpecialiteId());
                dto.setNomSpecialite((t.getSpecialite().getNomSpecialite()));
            }

            return dto;
        }).collect(Collectors.toList());
    }

    // Search by Nom
    public List<TeacherDto> searchByNom(String nom) {
        return teacherRepo.findByNomContainingIgnoreCase(nom).stream()
                .map(teacherComponent::toDto)
                .collect(Collectors.toList());
    }
}