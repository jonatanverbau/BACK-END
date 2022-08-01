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
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonatan
 */
@Service
@Transactional
public class ImpPersonaService implements IPersonaService{
    @Autowired 
    IPersonaRep iPersonaRep;

    @Override
    public List<Persona> list() {
        return iPersonaRep.findAll();
    }

    @Override
    public Optional<Persona> getOne(long id){
        return iPersonaRep.findById(id);
    }

    @Override
    public Optional<Persona> getByCorreo(String correo) {
        return iPersonaRep.findByCorreo(correo);
    }

    @Override
    public void save(Persona persona) {
        iPersonaRep.save(persona);
    }

    @Override
    public void delete(long id) {
        iPersonaRep.deleteById(id);
    }

    @Override
    public boolean existById(long id) {
        return iPersonaRep.existsById(id);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return iPersonaRep.existsByCorreo(correo);
    }

}
