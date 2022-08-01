/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.argprog.jverbauwede.Servicios;

import com.argprog.jverbauwede.Entidades.Experiencia;
import com.argprog.jverbauwede.Interfaces.IExperienciaService;
import com.argprog.jverbauwede.Repos.IExperienciaRep;
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
public class ImpExperienciaService implements IExperienciaService{
    @Autowired
    IExperienciaRep iExperienciaRep;
    
    @Override
    public List<Experiencia> getExperiencia() {
        return iExperienciaRep.findAll();
    }

    @Override
    public void save(Experiencia experiencia) {
        iExperienciaRep.save(experiencia);
    }
    
    @Override
    public void delete(Long id) {
        iExperienciaRep.deleteById(id);
    }

    @Override
    public boolean existsByNombreExp(String nombreExp) {
        return iExperienciaRep.existsByNombreExp(nombreExp);
    }

    @Override
    public Optional<Experiencia> findById(Long id) {
        return iExperienciaRep.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return iExperienciaRep.existsById(id);
    }

    @Override
    public Optional<Experiencia> getOne(Long id) {
        return iExperienciaRep.findById(id);
    }

    @Override
    public Optional<Experiencia> findByNombreExp(String nombreExp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Experiencia> getByNombreExp(String nombreExp) {
        return iExperienciaRep.findByNombreExp(nombreExp);
        }

}
