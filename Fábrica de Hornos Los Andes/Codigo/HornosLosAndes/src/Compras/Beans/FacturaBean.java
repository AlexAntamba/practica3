package Compras.Beans;

import java.io.Serializable;

public class FacturaBean implements Serializable{
	
	private int codigo;
	private int nroOrden;
	private double total;
	private String fecha;
	private String nombre;
	public String getFecha() {
		return fecha;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}	
}
