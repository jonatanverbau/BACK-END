/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.jverbauwede.Interfaces;

import com.argprog.jverbauwede.Entidades.Skills;
import java.util.List;

/**
 *
 * @author Jonatan
 */
public interface ISkillsService {
    //traer
    public List<Skills> getSkills();
    //guardar
    public void saveSkills(Skills skills);
    //borrar
    public void deleteSkills (Long id);
    //buscar
    public Skills findSkills(Long id);    
}
