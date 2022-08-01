/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.jverbauwede.Interfaces;

import com.argprog.jverbauwede.Entidades.Proyectos;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jonatan
 */
public interface IProyectosService {
    //traer
    public List<Proyectos> getProyectos();
    //traer uno
    public Optional<Proyectos> getOne(Long id);
    //guardar
    public void save(Proyectos proyectos);
    //borrar
    public void delete(Long id);
    //buscar por nombre
    public Optional<Proyectos> findByNombreProy (String nombreProy);
    //buscar por id
    public Optional<Proyectos> findById (Long id);
    //si existe por nombre
    public boolean existsByNombreProy(String nombreProy);
    //si existe por id
    public boolean existsById(Long id);
    //traer por nombre
    public Optional<Proyectos> getByNombreProy(String nombreProy);
}
