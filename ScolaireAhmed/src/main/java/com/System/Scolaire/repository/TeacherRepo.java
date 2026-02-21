package com.System.Scolaire.repository;

import com.System.Scolaire.model.entity.Specialite;
import com.System.Scolaire.model.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

    List<Teacher> findBySpecialite(Specialite specialite);

    List<Teacher> findByNomContainingIgnoreCase(String nom);

    // Alternative: Using @Query
    @Query("SELECT t FROM Teacher t WHERE t.specialite.specialiteId = :specialiteId")
    List<Teacher> findTeachersBySpecialiteId(@Param("specialiteId") Integer specialiteId);
}