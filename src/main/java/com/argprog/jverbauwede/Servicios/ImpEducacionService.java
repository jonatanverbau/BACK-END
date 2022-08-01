/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Service.java to edit this template
 */
package com.argprog.jverbauwede.Servicios;

import com.argprog.jverbauwede.Entidades.Educacion;
import com.argprog.jverbauwede.Interfaces.IEducacionService;
import com.argprog.jverbauwede.Repos.IEducacionRep;
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
public class ImpEducacionService implements IEducacionService{
    @Autowired
    IEducacionRep iEducacionRep;
    
    @Override
    public List<Educacion> getEducacion() {
        return iEducacionRep.findAll();
    }

    @Override
    public void save(Educacion educacion) {
        iEducacionRep.save(educacion);
    }
    
    @Override
    public void delete(Long id) {
        iEducacionRep.deleteById(id);
    }

    @Override
    public boolean existsByNombreEdu(String nombreEdu) {
        return iEducacionRep.existsByNombreEdu(nombreEdu);
    }

    @Override
    public Optional<Educacion> findById(Long id) {
        return iEducacionRep.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return iEducacionRep.existsById(id);
    }

    @Override
    public Optional<Educacion> getOne(Long id) {
        return iEducacionRep.findById(id);
    }

    @Override
    public Optional<Educacion> findByNombreEdu(String nombreEdu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Educacion> getByNombreEdu(String nombreEdu) {
        return iEducacionRep.findByNombreEdu(nombreEdu);
        }

}
