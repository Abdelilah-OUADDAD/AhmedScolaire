package com.System.Scolaire.service;

import java.util.List;

import com.System.Scolaire.model.Dto.TeacherDto;

public interface TeacherServiceInterface {

	List<TeacherDto> getAllTeachers();
	TeacherDto getTeacherById(Integer id);
	List<TeacherDto> getTeachersBySpecialite(Integer specialiteId);
	TeacherDto saveTeacher(TeacherDto dto);
	TeacherDto updateTeacher(TeacherDto dto) ;
	void deleteTeacher(Integer id);
	List<TeacherDto> getAllTeachersWithDetails() ;

}
