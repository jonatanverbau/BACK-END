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
public class DTOProyectos {
   
    @NotBlank
    private String nombreProy;
    private int anioProy;
    @NotBlank
    private String descProy;
    @NotBlank
    private String urlProy;
    @NotBlank
    private String img;

    public DTOProyectos() {
    }

    public DTOProyectos(String nombreProy, int anioProy, String descProy, String urlProy, String img) {
        this.nombreProy = nombreProy;
        this.anioProy = anioProy;
        this.descProy = descProy;
        this.urlProy = urlProy;
        this.img = img;
    }

    public String getNombreProy() {
        return nombreProy;
    }

    public void setNombreProy(String nombreProy) {
        this.nombreProy = nombreProy;
    }

    public int getAnioProy() {
        return anioProy;
    }

    public void setAnioProy(int anioProy) {
        this.anioProy = anioProy;
    }

    public String getDescProy() {
        return descProy;
    }

    public void setDescProy(String descProy) {
        this.descProy = descProy;
    }

    public String getUrlProy() {
        return urlProy;
    }

    public void setUrlProy(String urlProy) {
        this.urlProy = urlProy;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
