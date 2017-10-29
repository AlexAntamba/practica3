package UTIL.Service;

import UTIL.BD.DAOFactory;
import UTIL.Beans.UsuarioBean;
import UTIL.Interfaces.UsuarioDAO;
import UTIL.Params.Parametros;


public class LoginService {
	DAOFactory objDAOFactory = DAOFactory.getDAOFactory(Parametros.ORIGEN);
	UsuarioDAO objUsuarioDAO = objDAOFactory.getUsuarioDAO();
	
	public UsuarioBean validarUsuario(String login, String password) {
		System.out.println("Entro al service");
		return objUsuarioDAO.validarUsuario(login, password);
	}
}