/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Pais;
import com.tienda.repository.PaisRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daniela
 */
@Service
public class PaisService implements IPaisService{ //Hacemos lo mismo que en PersonaService, implementamos los métodos que creamos en IPaisService

    @Autowired
    private PaisRepository paisRepository;
    
    @Override
    public List<Pais> ListCountry() {
        return (List<Pais>)paisRepository.findAll(); //Nos devuelve una lista de objetos de tipo País.
    }
    
}
