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
    //traer listado
    public List<Persona> list();
    //traer 1
    public Optional<Persona> getOne(long id);
    //buscar por correo
    public Optional<Persona> getByCorreo (String correo);
    //guardar
    public void save(Persona persona);
    //borrar
    public void delete(long id);
    //si existe por id
    public boolean existById(long id);
    //si existe por correo
    public boolean existsByCorreo(String correo);
}