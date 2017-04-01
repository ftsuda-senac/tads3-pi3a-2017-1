<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <%
      for (int i = 1; i < 1001; i++) {
	%>
    <h1>Olá servlet <%= i %></h1>
    <%
      }
      %>
  </body>
</html>
