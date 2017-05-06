/*
 * The MIT License
 *
 * Copyright 2017 fernando.tsuda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads3.pi3a.agendaweb.filtro;

import br.senac.tads3.pi3a.agendaweb.model.UsuarioSistema;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author fernando.tsuda
 */
@WebFilter(filterName = "AutorizacaoFilter",
	servletNames = {"AgendaServlet", "EntradaServlet"},
	urlPatterns = {"/protegido/*"})
public class AutorizacaoFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request,
	  ServletResponse response, FilterChain chain)
	  throws IOException, ServletException {

    // 1) Verificar se usuario está logado.
    HttpServletRequest httpRequest
	    = (HttpServletRequest) request;
    HttpServletResponse httpResponse
	    = (HttpServletResponse) response;

    // 1a) Tenta recuperar sessao do usuario
    HttpSession sessao = httpRequest.getSession();
    UsuarioSistema usuario
	    = (UsuarioSistema) sessao.getAttribute("usuarioLogado");

    // Usuario nulo significa que nao está logado
    // Portanto solicita o login
    if (usuario == null) {
      httpResponse.sendRedirect(
	      httpRequest.getContextPath() + "/login");
      return;
    }

    // 2) Usuario esta logado, entao verifica se tem permissao
    // para acessar a pagina
    if (verificarAcesso(usuario, httpRequest, httpResponse)) {
      // Acesso do usuario a pagina está liberado
      chain.doFilter(request, response);
    } else {
      // Usuario nao tem permissao de acesso
      httpResponse.sendRedirect(httpRequest.getContextPath() 
	      + "/erroNaoAutorizado.jsp");
    }
  }

  private static boolean verificarAcesso(
	  UsuarioSistema usuario,
	  HttpServletRequest request,
	  HttpServletResponse response) {
    String paginaAcessada = request.getRequestURI();
    String pagina
	    = paginaAcessada.replace(request.getContextPath(), "");

    if (pagina.endsWith("entrada")
	    && usuario.temPapel("ADMIN")) {
      return true;
    } else if (pagina.endsWith("agenda")
	    && usuario.temPapel("BASICO")) {
      return true;
    }
    return false;
  }

  @Override
  public void destroy() {

  }

}
