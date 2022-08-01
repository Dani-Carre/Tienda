/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Internationalization --- i18n --- 18 letras entre I y n
 * Locale: Representa es el lenguaje, la región geográfica, variantes del dialecto/idioma, de un usuario
 * SessionLocaleResolver: guardar el Locale seleccionado por un usuario como atributo en el request HTTP
 * LocaleChageInterceptor: Detectar cualquier cambio de parte del usuario hacia lo que es el Locale
 * 
 * @author Daniela
 */
@Configuration //Aquí definimos nuestro archivo de configuración, que básicamente son las configuraciones que van a tener nuestro proyecto
public class WebConfig implements WebMvcConfigurer { //implementa los métodos de una interface
    
    @Bean //Estamos inyectando dependencias pero de configuración, de lo que debe de hacer nuestro programa cuando se está ejecutando
    public SessionLocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver(); //Esto crea un objeto que agrega a esa variable
        slr.setDefaultLocale(new Locale("es")); //tiene un método que se llama setDefaultLocale que le está seteando un objeto de tipo locale
        //el objeto de tipo locale lo que indica es el dialecto, idioma, la posición geográfica y toda la información referente al idioma en el que se quiere configurar nuestra página web.
        //la información se va a guardar en un objeto que se llama SessionLocaleResolver (Es como el nodo)
        return slr; //
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang"); //Lo que va a hacer es detectar el cambio que haya en nuestras páginas cuando le pasemos de parámetro "lang"
        //El escucha/detecta todos esos cambios mediante un Interceptor, en este caso se llama InterceptorRegistry
        return lci;        
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registro) { //Es una persona que va a captar todos los queries o información de todos los cambios que hayan en la página web
        registro.addInterceptor(localeChangeInterceptor()); //y les va a pasar de parámetro el método del localeChangeInterceptor
    }
}
