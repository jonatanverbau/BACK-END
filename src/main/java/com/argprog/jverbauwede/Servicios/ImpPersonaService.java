/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.argprog.jverbauwede.Servicios;

import com.argprog.jverbauwede.Entidades.Persona;
import com.argprog.jverbauwede.Interfaces.IPersonaService;
import com.argprog.jverbauwede.Repos.IPersonaRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonatan
 */
@Service
public class ImpPersonaService implements IPersonaService{
    @Autowired IPersonaRep ipersonaRep;
    
    @Override
    public List<Persona> getPersona() {
        return ipersonaRep.findAll();
    }

    @Override
    public void save(Persona persona) {
        ipersonaRep.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        ipersonaRep.deleteById(id);
    }

    @Override
    public Optional<Persona> getOne(Long id) {
        return ipersonaRep.findById(id);
    }
    
    @Override
    public Optional<Persona> getByCorreo(String correo) {
        return ipersonaRep.getByCorreo(correo);
    }
    
    @Override
    public boolean existsById(Long id){
        return ipersonaRep.existsById(id);
    }
    
    @Override
    public boolean existsByCorreo(String nombre){
        return ipersonaRep.existsByCorreo(nombre); 
    }
}
