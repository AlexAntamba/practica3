package DECORATOR;

import org.displaytag.decorator.TableDecorator;

import MaestroMateriales.Beans.MaterialBean;


public class MaterialesDecorator extends TableDecorator {

	public String getModificar(){
		MaterialBean mb = (MaterialBean)getCurrentRowObject();
		return "<a href=\"material?operacion=modificar&codigo=" + mb.getCodigo() +  "\">" + mb.getNombre() + "</a>";
	}
	
	public String getEliminar(){
		MaterialBean mb = (MaterialBean)getCurrentRowObject();
		return "<a href=\"material?operacion=eliminar&codigo=" + mb.getCodigo() +  "\">Eliminar</a>";
	}
	
	public String getComprar(){
		MaterialBean mb = (MaterialBean)getCurrentRowObject();
		return "<input type='checkbox' name='chkComprar' value='" + mb.getCodigo() + "'>";
	}
}
