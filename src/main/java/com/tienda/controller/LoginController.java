/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Daniela
 */
//Se debe crear un controlador para cada tabla

@Controller //Vamos a crear un controlador específicamente para crear el login
public class LoginController {
    
    @GetMapping("/login")
    public String index(){ 
        return "/login"; //este si va a ser nuestro html que se encuentra en templates
    }
    
}
