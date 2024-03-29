/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Daniela
 */

@Entity //mediante SpringBoot vamos a declarar estas sentencias para definir que esta clase va a ser nuestra entidad 
@Table(name="personas") //La entidad quiere modelar los datos de una tabla. Se hace el llamado a la tabla
public class Persona implements Serializable {
    @Id //Tenemos que definir el primary key, en este caso es ID
    //En el GeneratedValue indicamos como debería comportarse nuestro ID
    @GeneratedValue(strategy= GenerationType.IDENTITY) //Identity nos va a definir como auto-incremental
    //Aquí comenzamos a agregar todas la columnas de la tablas
    private long id;
    
    //Las columnas están definidas en la base de datos, por lo que está bien aquí mantenerlas como String
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String email;
    
    //Agregar Getter and setter
    private String password;
    private int active;
    private String roles = ""; //Estos son los primeros que estamos instanciando como si fuesen vacios
    private String permissions = ""; //Estos son los primeros que estamos instanciando como si fuesen vacios
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPermissions() {
        return permissions;
    }

    //Esto es de los nuevos campos que agregamos en la tabla persona en la "semana 10"
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
    
    //Agregamos los siguientes métodos
    //Lo que queremos es retornar una lista de permisos o roles, ya que en teoría un usuario puede tener varios permisos y varios roles.
    //Ejm un usuario puede ser administrador y usuario. Esto con el fin de hacer pruebas.            
    
    //Hay que modelar el foreign Key
    @ManyToOne //Hay que definir cual es la relación, en este caso es de muchos a uno.
    @JoinColumn(name="paises_id") //Hacemo un join a la columna donde tenemos referenciado el foreign key
    private Pais pais; //hay que crear una variable que apunte a esa tabla, en este caso un objeto de tipo Pais.
    
    //Ahora generamos los getters and setters.

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }  
    
    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        }
        return new ArrayList<>();
    }
    
    public List<String> getPermissionList() {
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        }
        return new ArrayList<>();
    }
    
}
