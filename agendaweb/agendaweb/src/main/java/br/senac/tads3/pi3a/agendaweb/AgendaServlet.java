/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.agendaweb;

import br.senac.tads3.pi3a.agendaweb.dao.ContatoDAO;
import java.io.IOException;
import java.util.List;
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

    ContatoDAO dao = new ContatoDAO();
    List<Contato> lista = dao.listar();
    
    request.setAttribute("listaContatos", lista);
    RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("agenda2.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (IOException ex) {

    }

  }

}
