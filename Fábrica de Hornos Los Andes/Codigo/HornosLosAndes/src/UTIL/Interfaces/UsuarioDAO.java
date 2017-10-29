package UTIL.Interfaces;

import UTIL.Beans.UsuarioBean;


public interface UsuarioDAO {
	UsuarioBean validarUsuario(String login, String password);
}
