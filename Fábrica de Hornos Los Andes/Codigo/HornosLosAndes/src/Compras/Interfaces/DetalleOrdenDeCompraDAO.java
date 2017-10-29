package Compras.Interfaces;

import java.util.ArrayList;

import Compras.Beans.DetalleOrdenDeCompraBean;


public interface DetalleOrdenDeCompraDAO {
	int ingresarDetalleOrdenDeCompra(DetalleOrdenDeCompraBean detalleorden);

	ArrayList<DetalleOrdenDeCompraBean> obtenerDetalles(int codigo);
}
