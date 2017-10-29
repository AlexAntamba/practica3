package DECORATOR;

import org.displaytag.decorator.TableDecorator;

import Compras.Beans.SistemaDeCompras;


public class ComprasDecorator extends TableDecorator {

	public int getCodigo(){
		SistemaDeCompras sc = (SistemaDeCompras)getCurrentRowObject();
		return sc.getHorno().getCodigo();
	}
	
	public String getModelo(){
		SistemaDeCompras sc = (SistemaDeCompras)getCurrentRowObject();
		return sc.getHorno().getModelo();
	}
	
	public int getStock(){
		SistemaDeCompras sc = (SistemaDeCompras)getCurrentRowObject();
		return sc.getHorno().getStock();
	}

	public String getDimensiones(){
		SistemaDeCompras sc = (SistemaDeCompras)getCurrentRowObject();
		return sc.getHorno().getDimensiones();
	}
}
