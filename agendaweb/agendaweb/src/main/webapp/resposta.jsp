<%-- 
    Document   : resposta
    Created on : 31/03/2017, 22:13:22
    Author     : fernando.tsuda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Novo contato adicionado</h1>
    <div>
      <%-- sessionScope permite obter os dados da sessão --%>
      <h2><c:out value="${sessionScope.novoContato.nome}" /></h2>
      <p><c:out value="${sessionScope.novoContato.email}" /></p>
      <p><c:out value="${sessionScope.novoContato.telefone}" /></p>
  </body>
  
  <%-- Apaga o valor da sessão --%>
  <c:remove scope="session" var="novoContato" />
</html>
