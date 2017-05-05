<%-- 
    Document   : login
    Created on : 05/05/2017, 19:46:34
    Author     : fernando.tsuda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Login</h1>
    <form action="login" method="post">
      <div>
	<label for="txtUsuario">Usuário</label>
	<div>
	  <input type="text" name="usuario" id="txtUsuario" />
	</div>
      </div>
      <div>
	<label for="txtSenha">Senha</label>
	<div>
	  <input type="password" name="senha" id="txtSenha" />
	</div>
      </div>
      <div>
	<input type="submit" value="Entrar" />
      </div>
    </form>
  </body>
</html>
