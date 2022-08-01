/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.service;

import com.tienda.entity.Persona;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Daniela
 */
//Necesitamos un objeto que almacene la información de nuestro usuario, información importante que nos va a permitir poder loguearnos
//Por ejemplo el username, el password, si está activo o no está activo

public class Userprincipal implements UserDetails { //va almacenar la información pertinente del usuario para poder loguearnos, esto va a poder ser utilizado en la autenticación
    private Persona persona; 
    
    public Userprincipal(Persona persona) { //de dónde tomamos la información del usuario? aquí le pasamos una persona, y apartir de esta persona es que vamo a obtener la información
        this.persona = persona;
    }

    @Override
    //Aquí tenemos nuestro primer método, getAuthorities.
    public Collection<? extends GrantedAuthority> getAuthorities() { //Nos va a devolver una lista llamada authorities
        List<GrantedAuthority> authorities = new ArrayList<>();// de tipo GrantedAuthority (es un objeto que nos va indicar cuales son los roles que posee un ususario)
        
        //Extract list of permissions (name)
        //Aquí estamos haciendo uso del método que creamos en la entidad de persona. Estamos usando el getPermissionList el cual debería devolver una lista 
        this.persona.getPermissionList().forEach(p -> { //por cada elemento en la lista le estamos indicando
            //tiene que hacer un nuevo objeto de tipo simpleGrantedAuthority, le vamos a pasar el permiso
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            //y lo agregamos a la lista de authorities
            authorities.add(authority);
        });
        
        //Extract list of roles (ROLE_name)
        //Los roles siempre tiene el prefijo de ROLE_, si no lo tiene él infiere que es un permiso
        this.persona.getRoleList().forEach(r -> { //Forma de poder iterar nuestra lista como tal (la flechita)
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });
        return authorities; //todo eso devuelve una lista que tiene todos los permisos y roles almacenados
    }

    @Override
    public String getPassword() {
        return this.persona.getPassword();
    }

    @Override
    public String getUsername() { //lo vamos a obtener de la persona el getNombre.
        return this.persona.getNombre();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() { //aquí estamos haciendo una comparación
        return this.persona.getActive() == 1; //que retorne si esta persona.getActive es igual a 1, que significa que está activa, si retorna 0 estaría inactiva 
    }
    
    
}
