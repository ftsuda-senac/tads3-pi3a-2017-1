<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--
  IMPORTAÇÃO DA BIBLIOTECA PARA USAR AS TAGS DA JSTL,
  PARA PERMITIR DESENVOLVER LÓGICA NA GERAÇÃO DO
  HTML DE SAÍDA
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <title>Agenda de contatos</title>
    <link rel="stylesheet" href="estilos.css" />
  </head>
  <body>
    <jsp:include page="./cabecalho.jsp" />
    <div class="conteudo">
      <h1>Agenda de contatos</h1>
      <div class="contatos">
	<table>
	  <tr>
	    <th>ID</th>
	    <th>Nome</th>
	    <th>Data nascimento</th>
	    <th>E-mail</th>
	    <th>Telefone</th>
	    <th>&nbsp;</th>
	  </tr>
	  <c:forEach items="${listaContatos}" var="contato">
	  <tr>
	    <td><c:out value="${contato.id}" /></td>
	    <td><c:out value="${contato.nome}" /></td>
	    <td><c:out value="${contato.dtNascimento}" /></td>
	    <td><c:out value="${contato.email}" /></td>
	    <td><c:out value="${contato.telefone}" /></td>
	    <td><a href="#">Alterar</a>|<a href="#">Excluir</a></td>
	  </tr>
	  </c:forEach>
	</table>
	<p><a href="entrada">Incluir novo contato</a></p>
      </div>
    </div>
  </body>
</html>