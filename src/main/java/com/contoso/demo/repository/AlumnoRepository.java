package com.contoso.demo.repository;

import java.util.Optional;

import com.contoso.demo.model.Alumno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
   @Query(value = "SELECT o FROM Alumno o WHERE o.id=?1")
   Optional<Alumno> findByCodigo(Integer id);
}
