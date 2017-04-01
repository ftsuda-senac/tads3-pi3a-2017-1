/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet("/agenda")
public class AgendaServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request,
	  HttpServletResponse response)
	  throws ServletException {

    List<Contato> lista = new ArrayList<>();
    lista.add(new Contato(1L, "Fulano da Silva",
	    new Date(), "fulano@zmail.com", "1234"));
    lista.add(new Contato(2L, "Ciclano de Souza",
	    new Date(), "ciclano@zmail.com", "5678"));
    lista.add(new Contato(3L, "Beltrana Maria",
	    new Date(), "beltrana@zmail.com", "9012"));
    
    request.setAttribute("listaContatos", lista);
    RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("agenda2.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (IOException ex) {

    }

  }

}
