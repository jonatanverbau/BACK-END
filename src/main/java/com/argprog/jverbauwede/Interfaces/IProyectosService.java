/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.jverbauwede.Interfaces;

import com.argprog.jverbauwede.Entidades.Proyectos;
import java.util.List;

/**
 *
 * @author Jonatan
 */
public interface IProyectosService {
    //traer
    public List<Proyectos> getProyectos();
    //guardar
    public void saveProyectos(Proyectos proyectos);
    //borrar
    public void deleteProyectos (Long id);
    //buscar
    public Proyectos findProyectos(Long id);    
}
