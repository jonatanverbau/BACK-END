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
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author Jonatan
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService iPersonaService;
            
    @GetMapping("/traer")
    public List<Persona> getPersona(){
        return iPersonaService.getPersona();
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id){
        if(!iPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"), HttpStatus.NOT_FOUND);
        Persona persona = iPersonaService.getOne(id).get();
        return new ResponseEntity(persona, HttpStatus.OK);
    }
       
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody DTOPersona personaDto){
        if(!iPersonaService.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no Existe"),HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("Debe ingresar nombre"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("Debe ingresar apellido"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getCorreo()))
            return new ResponseEntity(new Mensaje("Debe ingresar correo"), HttpStatus.BAD_REQUEST);
        Persona persona = iPersonaService.getOne(id).get();
        persona.setNombre(personaDto.getNombre());
        persona.setApellido(personaDto.getApellido());
        persona.setCorreo(personaDto.getCorreo());
        persona.setDescripcion(personaDto.getDescripcion());
        persona.setImg(personaDto.getImg());
        persona.setTitulo(personaDto.getTitulo());
            iPersonaService.save(persona);
            return new ResponseEntity(new Mensaje("Datos Personales Actualizados Correctamente"), HttpStatus.OK);
    }
    @PreAuthorize("hasAuthority('ROL_ADMIN')")
    @PostMapping("/crear")
    public ResponseEntity<?> create(@RequestBody DTOPersona personaDto){
        if(StringUtils.isBlank(personaDto.getNombre()))
            return new ResponseEntity(new Mensaje("El Nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getApellido()))
            return new ResponseEntity(new Mensaje("El Apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        if(StringUtils.isBlank(personaDto.getCorreo()))
            return new ResponseEntity(new Mensaje("El Correo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(iPersonaService.existsByCorreo(personaDto.getCorreo()))
            return new ResponseEntity(new Mensaje("El Correo ingresado ya existe"), HttpStatus.BAD_REQUEST);
        Persona persona = new Persona(personaDto.getNombre(), personaDto.getApellido(),
                                      personaDto.getCorreo(), personaDto.getDescripcion(), 
                                      personaDto.getImg(), personaDto.getTitulo());
        iPersonaService.save(persona);
        return new ResponseEntity(new Mensaje("Nueva Persona Agregada Correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/borrar/{id}")
        public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona fue eliminada correctamente";
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
    public Object handleError(HttpServletRequest req, Exception ex) {
        Object errorObject = new Object();
        return errorObject;
    }
    
}
