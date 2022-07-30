/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.jverbauwede.DTO;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Jonatan
 */
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
