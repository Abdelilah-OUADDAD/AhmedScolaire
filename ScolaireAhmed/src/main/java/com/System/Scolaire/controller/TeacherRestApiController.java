package com.System.Scolaire.controller;

import com.System.Scolaire.model.Dto.TeacherDto;
import com.System.Scolaire.service.TeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@CrossOrigin(origins = "*") // Allow all origins (for frontend)
public class TeacherRestApiController {

    @Autowired
    private TeacherService teacherService;

    // GET All Teachers
    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAllTeachers() {
        List<TeacherDto> teachers = teacherService.getAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    // GET Teacher by ID
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable Integer id) {
        TeacherDto teacher = teacherService.getTeacherById(id);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    // POST Create Teacher
    @PostMapping
    public ResponseEntity<TeacherDto> createTeacher(@RequestBody TeacherDto teacherDto) {
        TeacherDto savedTeacher = teacherService.saveTeacher(teacherDto);
        return new ResponseEntity<>(savedTeacher, HttpStatus.CREATED);
    }

    // PUT Update Teacher
    @PutMapping("/{id}")
    public ResponseEntity<TeacherDto> updateTeacher(@PathVariable Integer id,
            @RequestBody TeacherDto teacherDto) {
        TeacherDto existingTeacher = teacherService.getTeacherById(id);
        if (existingTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        teacherDto.setTeacherId(id); // Ensure ID is set
        TeacherDto updatedTeacher = teacherService.updateTeacher(teacherDto);
        return new ResponseEntity<>(updatedTeacher, HttpStatus.OK);
    }

    // DELETE Teacher
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable Integer id) {
        TeacherDto existingTeacher = teacherService.getTeacherById(id);
        if (existingTeacher == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // GET Teachers by Specialite
    @GetMapping("/specialite/{specialiteId}")
    public ResponseEntity<List<TeacherDto>> getTeachersBySpecialite(@PathVariable Integer specialiteId) {
        List<TeacherDto> teachers = teacherService.getTeachersBySpecialite(specialiteId);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    // Search Teachers by Nom
    @GetMapping("/search")
    public ResponseEntity<List<TeacherDto>> searchTeachers(@RequestParam String nom) {
        List<TeacherDto> teachers = teacherService.searchByNom(nom);
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }
}