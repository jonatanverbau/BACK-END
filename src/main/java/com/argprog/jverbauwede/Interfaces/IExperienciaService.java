/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argprog.jverbauwede.Interfaces;

import com.argprog.jverbauwede.Entidades.Experiencia;
import java.util.List;

/**
 *
 * @author Jonatan
 */
public interface IExperienciaService {
    //traer
    public List<Experiencia> getExperiencia();
    //guardar
    public void saveExperiencia(Experiencia experiencia);
    //borrar
    public void deleteExperiencia (Long id);
    //buscar
    public Experiencia findExperiencia(Long id);    
}
