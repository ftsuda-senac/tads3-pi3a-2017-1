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
    <h1>Agenda</h1>
    <%
    List<Contato> lista = new ArrayList<Contato>();
    lista.add(new Contato(1L, "Fulano da Silva",
	    new Date(), "fulano@zmail.com", "1234"));
    lista.add(new Contato(2L, "Ciclano de Souza",
	    new Date(), "ciclano@zmail.com", "5678"));
    lista.add(new Contato(3L, "Beltrana Maria",
	    new Date(), "beltrana@zmail.com", "9012"));
      
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
