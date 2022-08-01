/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.argprog.jverbauwede.Controller;

import com.argprog.jverbauwede.DTO.DTOProyectos;
import com.argprog.jverbauwede.Entidades.Proyectos;
import com.argprog.jverbauwede.Interfaces.IProyectosService;
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
@RequestMapping("/proyectos")
@CrossOrigin(origins = "http://localhost:4200")
public class ProyectosController {
    @Autowired

    IProyectosService iProyectosService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyectos>> list(){
        List<Proyectos> list = iProyectosService.getProyectos();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyectos> getById(@PathVariable("id")Long id){
        if(!iProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        Proyectos proyectos = iProyectosService.getOne(id).get();
        return new ResponseEntity(proyectos, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProyectos(@PathVariable("id") Long id){
        if(!iProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        iProyectosService.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DTOProyectos dtoproyectos){
        if(StringUtils.isBlank(dtoproyectos.getNombreProy()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(iProyectosService.existsByNombreProy(dtoproyectos.getNombreProy()))
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        Proyectos proyectos = new Proyectos(dtoproyectos.getNombreProy(), dtoproyectos.getAnioProy(),dtoproyectos.getImg(),dtoproyectos.getUrlProy(), dtoproyectos.getDescProy());
        iProyectosService.save(proyectos);
        return new ResponseEntity(new Mensaje("Proyecto creado"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody DTOProyectos dtoproyectos){
        if(!iProyectosService.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(iProyectosService.existsByNombreProy(dtoproyectos.getNombreProy()) && !Objects.equals(iProyectosService.getByNombreProy(dtoproyectos.getNombreProy()).get().getId(), id)){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoproyectos.getNombreProy())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyectos proyectos = iProyectosService.getOne(id).get();
        
        proyectos.setNombreProy(dtoproyectos.getNombreProy());
        proyectos.setAnioProy(dtoproyectos.getAnioProy());
        proyectos.setImg(dtoproyectos.getImg());
        proyectos.setDescProy(dtoproyectos.getDescProy());
        proyectos.setUrlProy(dtoproyectos.getUrlProy());
        
        iProyectosService.save(proyectos);
        
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
}
