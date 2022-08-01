/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.repository;

import com.tienda.entity.Persona;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniela
 */
@Repository //declaramos que este va a ser nuestro repositorio

/*Si se le hace cntl + click en el CrudRepository se abre una pestaña donde podemos ver los métodos.
Nos permite utilizar el save para guardar nuevos valores en nuestra base de datos, encontrar por ID,
ver si existe por un ID, hacer conteos, eliminar, etc.*/
public interface PersonaRepository extends CrudRepository<Persona,Long>{ //Aquí definimos el tipo de objeto que se va a utilizar.
    //En este caso es un objeto de tipo persona, y el tipo de ID que sería Long.
    
    //Queremos buscar a un usuario por el user name, por lo que creamos un método que nos encuentre por el nombre, pasandole el nombre. 
    Persona findByNombre (String nombre); //se le pone el nombre de la columna que queremos consultar.
    
    /*
    Podemos incrustar queries directamente en el código si quisieramos ejemplo:
    (Investigar más)
    
     'SELECT * FROM A'
            INNER JOIN B ON A.ID=B.ID
                WHERE ASDASD'
    */
    
}
