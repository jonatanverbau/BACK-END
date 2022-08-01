/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.jverbauwede.Interfaces;

import com.argprog.jverbauwede.Entidades.Experiencia;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jonatan
 */
public interface IExperienciaService {
    //traer
    public List<Experiencia> getExperiencia();
    //traer uno
    public Optional<Experiencia> getOne(Long id);
    //guardar
    public void save(Experiencia educacion);
    //borrar
    public void delete(Long id);
    //buscar por nombre
    public Optional<Experiencia> findByNombreExp (String nombreExp);
    //buscar por id
    public Optional<Experiencia> findById (Long id);
    //si existe por nombre
    public boolean existsByNombreExp(String nombreExp);
    //si existe por id
    public boolean existsById(Long id);
    //traer por nombre
    public Optional<Experiencia> getByNombreExp(String nombreExp);
}
