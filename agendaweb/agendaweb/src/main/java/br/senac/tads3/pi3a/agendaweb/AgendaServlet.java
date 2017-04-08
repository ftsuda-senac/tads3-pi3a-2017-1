/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads3.pi3a.agendaweb;

import br.senac.tads3.pi3a.agendaweb.dao.ContatoDAO;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
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
    
    String papel = request.getParameter("papel");
    request.setAttribute("papelUsuario", papel);

    // Efetua o processamento (neste caso, recuperar
    // a lista de contatos do banco
    //ContatoDAO dao = new ContatoDAO();
    //List<Contato> lista = dao.listar();
    List<Contato> lista = Arrays.asList(new Contato(1L, "Fulano",new Date(), "fulano@teste.com", "1234"));
    
    // Define um atributo para repassar a lista para o
    // JSP
    request.setAttribute("listaContatos", lista);
    
    // Lógica para encaminhar a requisição para continuar
    // o processamento no JSP.
    RequestDispatcher dispatcher = 
	    request.getRequestDispatcher("agenda.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (IOException ex) {

    }

  }

}
