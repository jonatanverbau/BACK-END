/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.jverbauwede.Interfaces;

import com.argprog.jverbauwede.Entidades.Skills;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jonatan
 */
public interface ISkillsService {
    //traer
    public List<Skills> getSkills();
    //traer uno
    public Optional<Skills> getOne(Long id);
    //guardar
    public void save(Skills skills);
    //borrar
    public void delete(Long id);
    //buscar por nombre
    public Optional<Skills> findByNombreSkill (String nombreSkill);
    //buscar por id
    public Optional<Skills> findById (Long id);
    //si existe por nombre
    public boolean existsByNombreSkill(String nombreSkill);
    //si existe por id
    public boolean existsById(Long id);
    //traer por nombre
    public Optional<Skills> getByNombreSkill(String nombreSkill);
}
