<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Inclusão de contato</title>
    <link rel="stylesheet" href="estilos.css" />
  </head>
  <body>
    <jsp:include page="./cabecalho.jsp" />
    <div class="contato">
      <h1>Inclusão de contato</h1>
      <div class="formulario">
	<form action="entrada" method="post">
	  <div>
	    <label for="txtnome">Nome</label>
	    <input type="text" name="nome" id="txtnome" />
	  </div>
	  <div>
	    <label for="txtemail">E-mail</label>
	    <input type="text" name="email" id="txtemail" />
	  </div>
	  <div>
	    <label for="txttelefone">Telefone</label>
	    <input type="text" name="telefone" id="txttelefone" />
	  </div>
	  <div>
	    <input type="submit" value="Salvar" />
	  </div>
	</form>
      </div>
    </div>
  </body>
</html>