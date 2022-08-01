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
public class DTOSkills {
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private int nivelSkill;
    @NotBlank
    private String img;

    public DTOSkills() {
    }

    public DTOSkills(String nombreSkill, int nivelSkill, String img) {
        this.nombreSkill = nombreSkill;
        this.nivelSkill = nivelSkill;
        this.img = img;
    }

    public String getNombreSkill() {
        return nombreSkill;
    }

    public void setNombreSkill(String nombreSkill) {
        this.nombreSkill = nombreSkill;
    }

    public int getNivelSkill() {
        return nivelSkill;
    }

    public void setNivelSkill(int nivelSkill) {
        this.nivelSkill = nivelSkill;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
}
