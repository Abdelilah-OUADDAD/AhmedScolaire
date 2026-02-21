package com.System.Scolaire.repository;

import com.System.Scolaire.model.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepo extends JpaRepository<Specialite, Integer> {
}