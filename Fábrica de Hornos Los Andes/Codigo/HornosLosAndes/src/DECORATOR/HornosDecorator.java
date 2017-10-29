package DECORATOR;

import org.displaytag.decorator.TableDecorator;

import MaestroHornos.Beans.HornoBean;


public class HornosDecorator extends TableDecorator {

	public String getModificar(){
		HornoBean h = (HornoBean)getCurrentRowObject();
		return "<a href=\"horno?operacion=modificar&codigo=" + h.getCodigo() +  "\">" + h.getModelo() + "</a>";
	}
	
	public String getEliminar(){
		HornoBean h = (HornoBean)getCurrentRowObject();
		return "<a href=\"horno?operacion=eliminar&codigo=" + h.getCodigo() +  "\">Eliminar</a>";
	}
	public String getComprar(){
		HornoBean h = (HornoBean)getCurrentRowObject();
		return "<input type='checkbox' name='chkComprar' value='" + h.getCodigo() + "'>";
	}
}
