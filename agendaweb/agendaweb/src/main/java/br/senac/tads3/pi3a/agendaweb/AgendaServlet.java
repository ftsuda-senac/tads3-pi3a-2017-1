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
    
    response.setContentType("text/html");
    try (PrintWriter out = response.getWriter()) {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset=\"utf-8\" />");
      out.println("<title>Primeiro Servlet</title>");
      out.println("</head>");
      out.println("<body>");
      for (int i = 1; i < 1001; i++) {
	out.println("<h1>Olá mundo Servlet " + i + "</h1>");
      }
      out.println("</body>");
      out.println("</html>");
      out.flush();
    } catch (IOException ex) {

    }
  }

}
