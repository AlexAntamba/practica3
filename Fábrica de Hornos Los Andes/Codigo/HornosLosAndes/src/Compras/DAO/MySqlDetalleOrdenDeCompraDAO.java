package Compras.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Compras.Beans.DetalleOrdenDeCompraBean;
import Compras.Interfaces.DetalleOrdenDeCompraDAO;

public class MySqlDetalleOrdenDeCompraDAO implements DetalleOrdenDeCompraDAO{
	
	public int ingresarDetalleOrdenDeCompra(DetalleOrdenDeCompraBean detalleorden) {
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
			String sql = "INSERT INTO tb_detalleordendecompra VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setInt(1, detalleorden.getNro());
			pstmt.setInt(2, detalleorden.getCodigo());
			pstmt.setDouble(3, detalleorden.getCantidad());
			pstmt.setDouble(4, detalleorden.getSubtotal());	
	
			//Paso 4: Se ejecuta la sentencia
			retorno = pstmt.executeUpdate();
			
			//Paso 5: Se evalúa el resultado
			
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
	public ArrayList<DetalleOrdenDeCompraBean> obtenerDetalles(int codigo) {
		
		// TODO Auto-generated method stub
		System.out.println("Codigo de Detalle : "+codigo);
		ArrayList<DetalleOrdenDeCompraBean> lista= new ArrayList<DetalleOrdenDeCompraBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM tb_detalleordendecompra where nro=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				DetalleOrdenDeCompraBean h = new DetalleOrdenDeCompraBean();
				
				h.setNro(rs.getInt("nro"));
				h.setCodigo(rs.getInt("codigo"));
				h.setCantidad(rs.getInt("cantidad"));
				h.setSubtotal(rs.getDouble("subtotal"));
				lista.add(h);
			}			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception e){e.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}		
		return lista;
	}
}
