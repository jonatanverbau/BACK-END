/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.jverbauwede.Interfaces;

import com.argprog.jverbauwede.Entidades.Educacion;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jonatan
 */
public interface IEducacionService {
    //traer
    public List<Educacion> getEducacion();
    //traer uno
    public Optional<Educacion> getOne(Long id);
    //guardar
    public void save(Educacion educacion);
    //borrar
    public void delete(Long id);
    //buscar por nombre
    public Optional<Educacion> findByNombreEdu (String nombreEdu);
    //buscar por id
    public Optional<Educacion> findById (Long id);
    //si existe por nombre
    public boolean existsByNombreEdu(String nombreEdu);
    //si existe por id
    public boolean existsById(Long id);
    //traer por nombre
    public Optional<Educacion> getByNombreEdu(String nombreEdu);
}
