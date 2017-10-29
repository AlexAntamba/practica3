package Compras.Interfaces;

import Compras.Beans.DetalleFacturaBean;
import Compras.Beans.FacturaBean;


public interface FacturaDAO {
	int ingresarFactura(FacturaBean factura);
	int ingresarDetalleFactura(DetalleFacturaBean detalle);
	int codigos();
}
