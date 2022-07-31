/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import com.tienda.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniela
 */
@Service //Declaramos que este va a ser nuestro Servicio.

public class PersonaService implements IPersonaService{ //Implementamos lo que tenemos en nuestra interface IPersonaService
/*Implementar todos los métodos abstractos, con eso por default se van a setear todos los métodos que ya habíamos hecho en la interface
  Se deben ir modificando*/
    
    /* El Autowired lo que nos va permitir es hacer una inyección de las dependencias.
    La dependencia va a ser utilizar o instanciar lo que es nuestro personaRepository.
    Se encarga de construir las conexiones entre los distintos elementos, esas conexiones se llaman 
    inyectar dependencias*/
    @Autowired
    private PersonaRepository personaRepository; //El primero es el objeto, el segundo es el atributo que puede ser nombrado como queramos. 
    
    @Override
    public List<Persona> getAllPersona() { //En este lo que queremos es devolver todas las personas en la tabla de personas
        return (List<Persona>)personaRepository.findAll(); //Lo que queremos es retornar una la lista de tipo persona del personaRepository.findAll
    }

    @Override
    public Persona getPersonaById(long id) {//En este lo que queremos es hacer una llamado de una persona por ID
        return personaRepository.findById(id).orElse(null); //si no lo encuentra devuelve nulo
    }

    @Override
    public void savePersona(Persona persona) {
        personaRepository.save(persona); //Aquí solo hacemos el llamado a personaRepository y guardamos en elemento en nuestra tabla
    }

    @Override
    public void delete(long id) {
        personaRepository.deleteById(id); //Pasamos el ID y elimnamos una fila de nuestra tabla, de acuerdo al ID. 
    }
    
}
