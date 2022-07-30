/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argprog.jverbauwede.Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Jonatan
 */
@Entity
public class Experiencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreExp;
    private String lugarExp;
    private int anioIniExp;
    private int anioFinExp;
    private String imgExp;
    private String descExp;

    public Experiencia() {
    }

    public Experiencia(String nombreExp, String lugarExp, int anioIniExp, int anioFinExp, String imgExp, String descExp) {
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Experiencia)) {
            return false;
        }
        Experiencia other = (Experiencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argprog.jverbauwede.Entidades.Experiencia[ id=" + id + " ]";
    }
    
}
