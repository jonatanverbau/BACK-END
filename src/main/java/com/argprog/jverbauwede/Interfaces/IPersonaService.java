/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.jverbauwede.Interfaces;

import com.argprog.jverbauwede.Entidades.Persona;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Jonatan
 */
public interface IPersonaService {
    //traer
    public List<Persona> getPersona();
    //guardar
    public void save(Persona persona);
    //borrar
    public void deletePersona (Long id);
    //buscar por id
    public Optional<Persona> getOne(Long id);
    //buscar por correo
    public Optional<Persona> getByCorreo (String correo);
    //si existe por correo
    public boolean existsByCorreo(String correo);
    //si existe por id
    public boolean existsById(Long id);
}
