/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.argprog.jverbauwede.Repos;

import com.argprog.jverbauwede.Entidades.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonatan
 */
@Repository
public interface IExperienciaRep extends JpaRepository<Experiencia, Long> {
    public Optional<Experiencia> findByNombreExp (String nombreExp);
    
    public boolean existsByNombreExp(String nombreExp);
}
