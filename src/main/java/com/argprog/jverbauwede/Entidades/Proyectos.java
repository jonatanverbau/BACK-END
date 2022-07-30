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
public class Proyectos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombreProy;
    private int anioProy;
    private String descProy;
    private String imgProy;

    public Proyectos() {
    }

    public Proyectos(String nombreProy, int anioProy, String descProy, String imgProy) {
        this.nombreProy = nombreProy;
        this.anioProy = anioProy;
        this.descProy = descProy;
        this.imgProy = imgProy;
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

    public String getImgProy() {
        return imgProy;
    }

    public void setImgProy(String imgProy) {
        this.imgProy = imgProy;
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
        if (!(object instanceof Proyectos)) {
            return false;
        }
        Proyectos other = (Proyectos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.argprog.jverbauwede.Entidades.Proyectos[ id=" + id + " ]";
    }
    
}
