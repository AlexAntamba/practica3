package Compras.Interfaces;

import java.util.ArrayList;

import Compras.Beans.OrdenDeCompraBean;



public interface OrdenDeCompraDAO {
	int ingresarOrdenDeCompra(OrdenDeCompraBean orden);
	ArrayList<OrdenDeCompraBean> consultarTodos();
	OrdenDeCompraBean consultarPorCodigo(int codigo);
	int actualizar(int nro);
	ArrayList<OrdenDeCompraBean> listarOrdenes();
}
