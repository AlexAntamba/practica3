package DECORATOR;

import org.displaytag.decorator.TableDecorator;

import Empleado.Beans.EmpleadoBean;


public class EmpleadosDecorator extends TableDecorator {

	public String getModificar(){
		EmpleadoBean e = (EmpleadoBean)getCurrentRowObject();
		return "<a href=\"empleado?operacion=modificar&codigo=" + e.getCodigo() +  "\">" + e.getNombre() + "</a>";
	}
	
	public String getEliminar(){
		EmpleadoBean e = (EmpleadoBean)getCurrentRowObject();
		return "<a href=\"empleado?operacion=eliminar&codigo=" + e.getCodigo() +  "\">Eliminar</a>";
	}
}
