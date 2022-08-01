/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.jverbauwede.DTO;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Jonatan
 */
@Setter
@Getter
public class DTOPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;  
    @NotBlank
    private String correo;
    @NotBlank
    private String img;   
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;   

    public DTOPersona(String nombre, String apellido, String correo, String img, String titulo, String descripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.img = img;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
}
