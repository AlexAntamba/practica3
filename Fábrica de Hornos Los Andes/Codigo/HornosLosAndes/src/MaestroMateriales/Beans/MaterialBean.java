package MaestroMateriales.Beans;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MaterialBean implements Serializable{
	private int codigo;
	private String nombre;
	private String tipo;
	private String durabilidad;
	private String fecreg;
	private String detuso;
	private int stock;
	private int estado;
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDurabilidad() {
		return durabilidad;
	}
	public void setDurabilidad(String durabilidad) {
		this.durabilidad = durabilidad;
	}
	public String getFecreg() {
		return fecreg;
	}
	public void setFecreg(String fecreg) {
		this.fecreg = fecreg;
	}
	public String getDetuso() {
		return detuso;
	}
	public void setDetuso(String detuso) {
		this.detuso = detuso;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}	
}
