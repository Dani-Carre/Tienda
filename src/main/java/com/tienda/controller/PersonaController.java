/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

import com.tienda.entity.Pais;
import com.tienda.entity.Persona;
import com.tienda.service.IPaisService;
import com.tienda.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Daniela
 */
@Controller //debemos definirlo 
public class PersonaController {
    
    //Inyectamos dependencias.
    @Autowired
    private IPersonaService personaService;
    
    @Autowired
    private IPaisService paisService;
    
    //GetMapping: Cuando nosotros escribamos en el URL lo definido el va a hacer todo lo que seteemos aquí 
    @GetMapping("/persona") //cuando reciba esto (localhost/persona) en el navegador va a reconocer que tiene que realizar toda esta acción
    public String index (Model model){ //Va a devolver un objeto de tipo String
        //Definimos un objeto de tipo Model que lo que va a hacer es permitir pasarle información a mi html personas
        List<Persona> listaPersona = personaService.getAllPersona(); //Lo que quiero pasarle a mi html es la lista de personas
        model.addAttribute("titulo","Tabla Personas"); //Cuando vean titulo lo va a sustituir y le va a colocar Tabla Personas
        //donde se encuentre personas en mi html se reemplazará por listaPersona que es el que contiene toda la información
        model.addAttribute("personas",listaPersona); //Esta listaPersona es lo que yo le voy a enviar a mi html
        return "personas"; //En este caso devuelve un html que se llama personas.
    }

    @GetMapping("/personaN")
    public String crearPersona (Model model){
        List<Pais> listaPaises = paisService.ListCountry();
        model.addAttribute("persona",new Persona());
        model.addAttribute("paises",listaPaises);
        return "crear";
    }
    
    @PostMapping("/save")
    public String guardarPersona (@ModelAttribute Persona persona){
        personaService.savePersona(persona); //con esto lo guardo en mi base de datos
        return "redirect:/persona";
    }
    
     @GetMapping("/editPersona/{id}")
    public String editarPersona (@PathVariable("id") Long idPersona, Model model){
        Persona persona = personaService.getPersonaById(idPersona);
        List<Pais> listaPaises = paisService.ListCountry();
        model.addAttribute("persona",persona);
        model.addAttribute("paises",listaPaises);
        return "crear";
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarPersona (@PathVariable("id") Long idPersona){
        personaService.delete(idPersona);
        return "redirect:/persona";
    }
    
    //Pruebas para el JASPER REPORT
        
}
