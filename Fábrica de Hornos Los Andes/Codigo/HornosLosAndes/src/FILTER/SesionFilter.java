package FILTER;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import UTIL.Beans.AuditoriaBean;
import UTIL.Service.AuditoriaService;
import UTIL.Service.LoginService;


/**
 * Servlet Filter implementation class SesionFilter
 */
public class SesionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SesionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String login = request.getParameter("usuario");
		String password = request.getParameter("contrasena");
		LoginService service = new LoginService();
		if (service.validarUsuario(login, password) != null){
			AuditoriaService serv = new AuditoriaService();
			AuditoriaBean auditoria = new AuditoriaBean();
			ArrayList<AuditoriaBean> lista=serv.obtenerCodigo();
			auditoria.setCodigo(lista.size()+1);
			auditoria.setUsuario(login);
			auditoria.setAccion("login");
			auditoria.setDetalle("Ha Entrado en sesion");			
			serv.ingresar(auditoria);
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
