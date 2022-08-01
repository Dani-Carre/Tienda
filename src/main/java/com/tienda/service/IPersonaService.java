/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.List;

/**
 *
 * @author Daniela
 */

//Aquí vamos a definir los métodos que vamos a utilizar
public interface IPersonaService {
    public List<Persona> getAllPersona(); //Nuestros objetos se llaman persona, entonces los vamos a llamar y pedir que nos los guarde en una lista. 
    public Persona getPersonaById (long id); //Con este obtenemos una persona de nuestra BD de acuerdo al ID que solicitemos.s
    //Estos son voids porque no devuelven información
    public void savePersona(Persona persona); //Con este insertamos una nueva fila en nuestra tabla personas
    public void delete (long id); //Aquí eliminamos una fila de nuestra BD de acuerdo al ID indicado
    public Persona findByNombre (String nombre); //Agregamos la función que incluímos en el PersonaRepository
    
}
