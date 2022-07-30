/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package com.argprog.jverbauwede.Repos;

import com.argprog.jverbauwede.Entidades.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonatan
 */
@Repository
public interface ISkillsRepo extends JpaRepository<Skills, Long> {
    public Optional<Skills> findByNombreSkill (String nombreSkill);
    
    public boolean existsByNombreSkill(String nombreSkill);    
}
