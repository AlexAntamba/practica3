package DECORATOR;

import org.displaytag.decorator.TableDecorator;

import MaestroProveedores.Beans.ProveedorBean;


public class ProveedoresDecorator extends TableDecorator{
	
	public String getModificar(){
		ProveedorBean h = (ProveedorBean)getCurrentRowObject();
		return "<a href=\"proveedor?operacion=modificar&codigo=" + h.getCodigo() +  "\">" + h.getNombre() + "</a>";
	}
	
	public String getEliminar(){
		ProveedorBean h = (ProveedorBean)getCurrentRowObject();
		return "<a href=\"proveedor?operacion=eliminar&codigo=" + h.getCodigo() +  "\">Eliminar</a>";
	}
}
