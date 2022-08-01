/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/RestController.java to edit this template
 */
package com.argprog.jverbauwede.Controller;

import com.argprog.jverbauwede.DTO.DTOPersona;
import com.argprog.jverbauwede.Entidades.Persona;
import com.argprog.jverbauwede.Interfaces.IPersonaService;
import com.argprog.jverbauwede.Security.Controller.Mensaje;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Jonatan
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService iPersonaService;
            
    @GetMapping("/lista")
    public ResponseEntity<Optional<Persona>> getPersona(){
        return new ResponseEntity(iPersonaService.getOne(1),HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") long id){
        if(!iPersonaService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
        Persona persona = iPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
    
    @PostMapping ("/save")
    public ResponseEntity<?> create(@RequestBody DTOPersona personaDto){
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("El Apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(iPersonaService.existsByCorreo(personaDto.getCorreo()))
            return new ResponseEntity(new Mensaje("El Correo ingresado ya existe"), HttpStatus.BAD_REQUEST);
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getTitulo(), personaDto.getApellido(),
                                      personaDto.getDescripcion(), personaDto.getImg(), personaDto.getCorreo());
        iPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Nueva Persona Agregada Correctamente"), HttpStatus.OK);
    }
    
    @PutMapping ("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody DTOPersona personaDto){
        if(!iPersonaService.existById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("El Apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        Persona persona = iPersonaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setTitulo(personaDto.getTitulo());
        persona.setApellido(personaDto.getApellido());
        persona.setDescripcion(personaDto.getDescripcion());
        persona.setImg(personaDto.getImg());
        persona.setCorreo(personaDto.getCorreo());
            iPersonaService.save(persona);
            return new ResponseEntity(new Mensaje("Datos Personales Actualizados Correctamente"), HttpStatus.OK);
    }
    
}
