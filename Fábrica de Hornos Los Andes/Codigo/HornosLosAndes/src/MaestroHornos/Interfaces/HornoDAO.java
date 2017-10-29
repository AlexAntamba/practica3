package MaestroHornos.Interfaces;

import java.util.ArrayList;

import MaestroHornos.Beans.HornoBean;


public interface HornoDAO {
	int ingresarHorno(HornoBean Horno);
	int modificarHorno(HornoBean Horno);
	int eliminarHorno(int codigo);
	ArrayList<HornoBean> consultarTodos();	
	HornoBean consultarPorCodigo(int codigo);
	ArrayList<HornoBean> buscarHornos(String modelo);
	ArrayList<HornoBean> consultarCodigos();
	int actualizarStock(int codigo,int cantidad);
	ArrayList<HornoBean> listarTodos();
}
