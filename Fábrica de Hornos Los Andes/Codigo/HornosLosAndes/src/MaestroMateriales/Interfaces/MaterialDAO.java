package MaestroMateriales.Interfaces;

import java.util.ArrayList;

import MaestroMateriales.Beans.MaterialBean;


public interface MaterialDAO {
	int ingresarMaterial(MaterialBean Material);
	int modificarMaterial(MaterialBean Material);
	int eliminarMaterial(int codigo);
	ArrayList<MaterialBean> consultarTodos();
	MaterialBean consultarPorCodigo(int codigo);
	ArrayList<MaterialBean> buscarMateriales(String nombre, String tipo);
	ArrayList<MaterialBean> consultarCodigos();
}
