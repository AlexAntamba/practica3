package Compras.Beans;

import MaestroHornos.Beans.HornoBean;

public class SistemaDeCompras {
	private HornoBean horno;
	public HornoBean getHorno() {
		return horno;
	}
	public void setHorno(HornoBean horno) {
		this.horno = horno;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	private int cantidad;
}
