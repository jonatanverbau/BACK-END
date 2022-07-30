/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.argprog.jverbauwede.Repos;

import com.argprog.jverbauwede.Entidades.Educacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonatan
 */
@Repository
public interface IEducacionRep extends JpaRepository<Educacion, Long> {
    public Optional<Educacion> findByNombreEdu (String nombreEdu);
    
    public boolean existsByNombreEdu(String nombreEdu);
}
