/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.argprog.jverbauwede.Servicios;

import com.argprog.jverbauwede.Entidades.Proyectos;
import com.argprog.jverbauwede.Interfaces.IProyectosService;
import com.argprog.jverbauwede.Repos.IProyectosRep;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonatan
 */
@Service
public class ImpProyectosService implements IProyectosService {

    @Autowired IProyectosRep iProyectosRep;
    @Override
    public List<Proyectos> getProyectos() {
        return iProyectosRep.findAll();
    }

    @Override
    public void save(Proyectos proyectos) {
        iProyectosRep.save(proyectos);
    }
    
    @Override
    public void delete(Long id) {
        iProyectosRep.deleteById(id);
    }

    @Override
    public boolean existsByNombreProy(String nombreProy) {
        return iProyectosRep.existsByNombreProy(nombreProy);
    }

    @Override
    public Optional<Proyectos> findById(Long id) {
        return iProyectosRep.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return iProyectosRep.existsById(id);
    }

    @Override
    public Optional<Proyectos> getOne(Long id) {
        return iProyectosRep.findById(id);
    }

    @Override
    public Optional<Proyectos> findByNombreProy(String nombreProy) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Proyectos> getByNombreProy(String nombreProy) {
        return iProyectosRep.findByNombreProy(nombreProy);
        }
    
}
