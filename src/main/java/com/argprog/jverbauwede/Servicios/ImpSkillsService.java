/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.argprog.jverbauwede.Servicios;

import com.argprog.jverbauwede.Entidades.Skills;
import com.argprog.jverbauwede.Interfaces.ISkillsService;
import com.argprog.jverbauwede.Repos.ISkillsRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonatan
 */
@Service
public class ImpSkillsService implements ISkillsService{
    @Autowired ISkillsRep iSkillsRep;
            
        @Override
    public List<Skills> getSkills() {
        return iSkillsRep.findAll();
    }

    @Override
    public void save(Skills skills) {
        iSkillsRep.save(skills);
    }
    
    @Override
    public void delete(Long id) {
        iSkillsRep.deleteById(id);
    }

    @Override
    public boolean existsByNombreSkill(String nombreSkill) {
        return iSkillsRep.existsByNombreSkill(nombreSkill);
    }

    @Override
    public Optional<Skills> findById(Long id) {
        return iSkillsRep.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return iSkillsRep.existsById(id);
    }

    @Override
    public Optional<Skills> getOne(Long id) {
        return iSkillsRep.findById(id);
    }

    @Override
    public Optional<Skills> findByNombreSkill(String nombreSkill) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Skills> getByNombreSkill(String nombreSkill) {
        return iSkillsRep.findByNombreSkill(nombreSkill);
        }
    
}
