package Compras.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Compras.Beans.DetalleFacturaBean;
import Compras.Beans.FacturaBean;
import Compras.Interfaces.FacturaDAO;

public class MySqlFacturaDAO implements FacturaDAO{

	@Override
	public int codigos() {		// TODO Auto-generated method stub
		ArrayList<FacturaBean> lista= new ArrayList<FacturaBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM tb_factura";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				FacturaBean f = new FacturaBean();
				f.setCodigo(rs.getInt("codigo"));
				f.setNombre(rs.getString("nombre"));
				f.setNroOrden(rs.getInt("nroOrden"));
				f.setTotal(rs.getDouble("total"));
				f.setFecha(rs.getString("fecha"));
				lista.add(f);
			}			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception e){e.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}		
		return lista.size()+1;
	}

	@Override
	public int ingresarDetalleFactura(DetalleFacturaBean detalle) {
		// TODO Auto-generated method stub
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "INSERT INTO tb_detallefactura VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);						
			pstmt.setInt(1,detalle.getCodigo() );
			pstmt.setInt(2,detalle.getCodHorno());
			pstmt.setDouble(3,detalle.getCantidad());
			pstmt.setDouble(4,detalle.getPrecio());
			pstmt.setDouble(5,detalle.getSubtotal());	
			//Paso 4: Se ejecuta la sentencia
			retorno = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}
		return retorno;
	}
	@Override
	public int ingresarFactura(FacturaBean factura) {
		// TODO Auto-generated method stub
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "INSERT INTO tb_factura VALUES(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);						
			pstmt.setInt(1,factura.getCodigo());
			pstmt.setString(2,factura.getNombre());
			pstmt.setInt(3,factura.getNroOrden());
			pstmt.setDouble(4,factura.getTotal());
			pstmt.setString(5, factura.getFecha());	
			//Paso 4: Se ejecuta la sentencia
			retorno = pstmt.executeUpdate();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}		
		return retorno;
	}

}
