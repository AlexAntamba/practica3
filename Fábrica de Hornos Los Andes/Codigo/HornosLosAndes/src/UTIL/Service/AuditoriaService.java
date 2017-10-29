package UTIL.Service;

import java.util.ArrayList;

import UTIL.Beans.AuditoriaBean;
import UTIL.DAO.MySqlAuditoriaDAO;


public class AuditoriaService {
	public int ingresar(AuditoriaBean auditoria){
		MySqlAuditoriaDAO MySqlAuditoriaDAO = new MySqlAuditoriaDAO();
		return MySqlAuditoriaDAO.ingresarAuditoria(auditoria);
	}
	public ArrayList<AuditoriaBean> obtenerCodigo(){
		MySqlAuditoriaDAO MySqlAuditoriaDAO = new MySqlAuditoriaDAO();
		return MySqlAuditoriaDAO.obtenerCodigo();		
	}
}
