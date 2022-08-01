/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

/**
 *
 * @author Daniela
 */

//Manejar las excepciones y cuando las autenticaciones han sido exitosas. 
public class AppAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
  protected void handle(HttpServletRequest request, HttpServletResponse response,
          Authentication authentication) throws IOException, ServletException  {
      
  }
    
}
