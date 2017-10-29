package DECORATOR;

import org.displaytag.decorator.TableDecorator;

import Compras.Beans.OrdenDeCompraBean;


public class OrdenDecorator extends TableDecorator{
		
	public String getListar(){
		OrdenDeCompraBean oc = (OrdenDeCompraBean)getCurrentRowObject();
		return "<a href=\"factura?operacion=listar&codigo=" + oc.getNro() +  "\">" + oc.getNro() + "</a>";
	}	
}
