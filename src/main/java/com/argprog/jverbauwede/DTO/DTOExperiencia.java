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
public class DTOExperiencia {
    @NotBlank
    private String nombreExp;
    @NotBlank
    private String lugarExp;
    @NotBlank
    private int anioIniExp;
    private int anioFinExp;
    private String imgExp;
    private String descExp;


    public DTOExperiencia() {
    }

    public DTOExperiencia(String nombreExp, String lugarExp, int anioIniExp, int anioFinExp, String imgExp, String descExp) {
        this.nombreExp = nombreExp;
        this.lugarExp = lugarExp;
        this.anioIniExp = anioIniExp;
        this.anioFinExp = anioFinExp;
        this.imgExp = imgExp;
        this.descExp = descExp;
    }

    public String getNombreExp() {
        return nombreExp;
    }

    public void setNombreExp(String nombreExp) {
        this.nombreExp = nombreExp;
    }

    public String getLugarExp() {
        return lugarExp;
    }

    public void setLugarExp(String lugarExp) {
        this.lugarExp = lugarExp;
    }

    public int getAnioIniExp() {
        return anioIniExp;
    }

    public void setAnioIniExp(int anioIniExp) {
        this.anioIniExp = anioIniExp;
    }

    public int getAnioFinExp() {
        return anioFinExp;
    }

    public void setAnioFinExp(int anioFinExp) {
        this.anioFinExp = anioFinExp;
    }

    public String getImgExp() {
        return imgExp;
    }

    public void setImgExp(String imgExp) {
        this.imgExp = imgExp;
    }

    public String getDescExp() {
        return descExp;
    }

    public void setDescExp(String descExp) {
        this.descExp = descExp;
    }
    
}