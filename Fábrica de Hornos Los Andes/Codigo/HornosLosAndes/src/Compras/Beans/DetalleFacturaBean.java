package Compras.Beans;

import java.io.Serializable;

public class DetalleFacturaBean implements Serializable{
	
	private int codigo;
	private int codHorno;
	private int cantidad;
	private double precio;
	private double subtotal;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCodHorno() {
		return codHorno;
	}
	public void setCodHorno(int codHorno) {
		this.codHorno = codHorno;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	

}
