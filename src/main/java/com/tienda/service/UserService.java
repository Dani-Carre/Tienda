/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniela
 */

//En el UserService vamos a utilizar la información que fue almacenada en el Userprincipal
@Service
public class UserService implements UserDetailsService { //él va a interactual con el Spring Security

    @Autowired
    public IPersonaService personaService; //vamos a utilizar el personaService para obtener nuestra persona
            
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = this.personaService.findByNombre(username); //dado un username extraemos la persona
        Userprincipal userPrincipal = new Userprincipal(persona); //creamos un nuevo objeto, que tiene encapsulada toma la info que requerimos
        return userPrincipal;
    }
    
}
