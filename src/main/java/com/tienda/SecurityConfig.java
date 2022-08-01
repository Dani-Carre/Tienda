/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import com.tienda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 *
 * @author Daniela
 */

/*Al igual que el WebConfig es del tipo configuration
Lo que va a hacer es almacenar o entender con tal que la información que estamos haciendo es meramente de 
configuración para que cuando la aplicación inicie saber que es lo que tiene que hacer ahí como background.
Que está corriendo como por detrás.
*/
@Configuration //Para cuando él ya comienza a correr por detrás
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter { //Se va a encargar de setear nuestra configuración de seguridad basada en springframework
    //Este archivo de SecurityConfig es el que va a correr/compilar todo lo que es nuestra seguridad al iniciar nuestra aplicación
    
    @Autowired
    private UserService userDetailsService; //El tipo de dependencia es de tipo UserService
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //Aquí le estamos indicando que tipo de codificación es el que estamos utilizando, en este caso es el de tipo BCrypt
        return new BCryptPasswordEncoder(); //Nada más estamos devolviendo un objeto como tal de BCrypt 
    }
    
    @Bean
    public UserService getUserService() { //Obtenemos el UserService
        return new UserService();
    }
    
    @Bean
    DaoAuthenticationProvider authenticationProvider() { //Es lo que va a empezar a hacer la autenticación mediante el Spring Security
      DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(); //Creamos un objeto
      daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()); //Le seteamos el tipo de codificación que vamos a utilizar en la contraseña  
      daoAuthenticationProvider.setUserDetailsService(getUserService()); //Le pasamos un objeto de tipo UserService
      return daoAuthenticationProvider; //y simplemente lo devolvemos
    }
    
    @Bean
    //Este método nos va a ayudar a saber que hacer si mi autenticación fue exitosa
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
      return new AppAuthenticationSuccessHandler(); 
    }
    
    //Este es el contructor, se le pasa el user service y se instancia
    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }
    
    @Override
    //Configuraciones que vamos a hacer, le pasamos un objeto ..Builder, pero se necesita pasarle el provider
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }
    
    //El siguiente método funciona para hacer la autenticación del usuario

    /**
     *
     * @param http
     * @throws Exception
     */
    @Override
    
    //Nos va a dar nuestro acceso a http
    protected void configure(HttpSecurity http) throws Exception {
        //Aquí le indicamos si nuestros request están autorizados 
        //El endpoint es la ruta que estamos utilizando en nuestro REST API
        //Endpoint: consulta, request, petición que le estamos haciendo al backend
        http.authorizeRequests()
                .antMatchers("/persona","/login","/personaN") //Tiene acceso a estos endpoints si su role es de ADMIN 
                .hasRole("ADMIN") //Si usted tiene el role de ADMIN, tiene acceso a los que estén incluidos en el anterior
                .antMatchers("/persona", "/","/login") //A estos endpoints pueden ir cualquier que tenga los siguientes roles (user, vendedor, admin)
                .hasAnyRole("USER","VENDEDOR","ADMIN") //Estos roles pueden ir a los endpoints anteriores
                .anyRequest().authenticated() //autentica el request
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/persona",true);
                //indicamos que nos dirija a ese endpoint y si el login es exitoso quiero que por default me dirija a ese otro endpoint /persona
    }
    

 }