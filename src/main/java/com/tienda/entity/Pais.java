/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Daniela
 */
@Entity //Definimos que es una entidad
@Table(name="paises") //Que vamos a modelar lo de la tabla de países
public class Pais implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String pais;

    public long getId() {
        return id;
    }

    public void setId(long id) { //este es un parámetro: nombramos los parámetros que requerimos para ejecutar el método 
        this.id = id; //el argumento es el valor 
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
