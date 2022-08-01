/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.argprog.jverbauwede.Controller;

import com.argprog.jverbauwede.DTO.DTOSkills;
import com.argprog.jverbauwede.Entidades.Skills;
import com.argprog.jverbauwede.Interfaces.ISkillsService;
import com.argprog.jverbauwede.Security.Controller.Mensaje;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;


/**
 *
 * @author Jonatan
 */
@RestController
@RequestMapping("/skills")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillsController {
    @Autowired

    ISkillsService iSkillsService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skills>> list(){
        List<Skills> list = iSkillsService.getSkills();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skills> getById(@PathVariable("id")Long id){
        if(!iSkillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Skills skills = iSkillsService.getOne(id).get();
        return new ResponseEntity(skills, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSkills(@PathVariable("id") Long id){
        if(!iSkillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        iSkillsService.delete(id);
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOSkills dtoskills){
        if(StringUtils.isBlank(dtoskills.getNombreSkill()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(iSkillsService.existsByNombreSkill(dtoskills.getNombreSkill()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Skills skills = new Skills(dtoskills.getNombreSkill(), dtoskills.getNivelSkill(),dtoskills.getImg());
        iSkillsService.save(skills);
        return new ResponseEntity(new Mensaje("Skill creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DTOSkills dtoskills){
        if(!iSkillsService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(iSkillsService.existsByNombreSkill(dtoskills.getNombreSkill()) && !Objects.equals(iSkillsService.getByNombreSkill(dtoskills.getNombreSkill()).get().getId(), id)){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoskills.getNombreSkill())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Skills skills = iSkillsService.getOne(id).get();
        
        skills.setNombreSkill(dtoskills.getNombreSkill());
        skills.setNivelSkill(dtoskills.getNivelSkill());
        skills.setImg(dtoskills.getImg());
        
        iSkillsService.save(skills);
        
        return new ResponseEntity(new Mensaje("Skill actualizado"), HttpStatus.OK);
    }
}
