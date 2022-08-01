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
public class DTOEducacion {

    @NotBlank
    private String nombreEdu;
    @NotBlank
    private String lugarEdu;
    @NotBlank
    private int anioEdu;
    private String img;
    private String descEdu;

    public DTOEducacion() {
    }

    public DTOEducacion(String nombreEdu, String lugarEdu, int anioEdu, String img, String descEdu) {
        this.nombreEdu = nombreEdu;
        this.lugarEdu = lugarEdu;
        this.anioEdu = anioEdu;
        this.img = img;
        this.descEdu = descEdu;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescEdu() {
        return descEdu;
    }

    public void setDescEdu(String descEdu) {
        this.descEdu = descEdu;
    }  

    public String getLugarEdu() {
        return lugarEdu;
    }

    public void setLugarEdu(String lugarEdu) {
        this.lugarEdu = lugarEdu;
    }

    public int getAnioEdu() {
        return anioEdu;
    }

    public void setAnioEdu(int anioEdu) {
        this.anioEdu = anioEdu;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
