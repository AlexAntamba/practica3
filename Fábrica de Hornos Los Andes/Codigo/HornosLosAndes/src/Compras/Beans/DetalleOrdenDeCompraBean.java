package Compras.Beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class DetalleOrdenDeCompraBean implements Serializable{
	private int nro;
	private int codigo;
	private int cantidad;
	private double subtotal;
	
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getNro() {
		return nro;
	}
	public void setNro(int nro) {
		this.nro = nro;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}	
}
