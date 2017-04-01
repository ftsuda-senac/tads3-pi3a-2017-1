<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senac.tads3.pi3a.agendaweb.Contato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Agenda Servlet + JSP</h1>
    <%
      List<Contato> lista = 
	      (ArrayList<Contato>) request.getAttribute("listaContato");
      
      for (Contato c : lista) {
	%>
	<div>
	  <h2><%= c.getNome() %></h2>
	  <p><%= c.getEmail()%></p>
	</div>
    <%
      }
      %>
  </body>
</html>
