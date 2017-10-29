package Compras.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Compras.Beans.OrdenDeCompraBean;
import Compras.Interfaces.OrdenDeCompraDAO;


public class MySqlOrdenDeCompraDAO implements OrdenDeCompraDAO{
	@Override
	public OrdenDeCompraBean consultarPorCodigo(int nro) {
		// TODO Auto-generated method stub
		OrdenDeCompraBean oc = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM tb_ordendecompra WHERE nro=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nro);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			if (rs.next()){
				oc = new OrdenDeCompraBean();
				
				oc.setNro(rs.getInt("nro"));
				oc.setPrioridad(rs.getString("prioridad"));
				oc.setFecha(rs.getString("fecha"));	
				oc.setEstado(rs.getInt("estado"));
						
			}			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception e){e.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}
		return oc;
	}

	@Override
	public ArrayList<OrdenDeCompraBean> consultarTodos() {
		// TODO Auto-generated method stub
		ArrayList<OrdenDeCompraBean> lista= new ArrayList<OrdenDeCompraBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM tb_ordendecompra";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				OrdenDeCompraBean h = new OrdenDeCompraBean();
				h.setNro(rs.getInt("nro"));
				h.setEstado(rs.getInt("estado"));
				h.setPrioridad(rs.getString("prioridad"));
				h.setFecha(rs.getString("fecha"));
				
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
	
	public ArrayList<OrdenDeCompraBean> listarOrdenes() {
		// TODO Auto-generated method stub
		ArrayList<OrdenDeCompraBean> lista= new ArrayList<OrdenDeCompraBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM tb_ordendecompra where estado=0";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				OrdenDeCompraBean h = new OrdenDeCompraBean();
				h.setNro(rs.getInt("nro"));
				h.setEstado(rs.getInt("estado"));
				h.setPrioridad(rs.getString("prioridad"));
				h.setFecha(rs.getString("fecha"));
				
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

	@Override
	public int ingresarOrdenDeCompra(OrdenDeCompraBean orden) {
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
			String sql = "INSERT INTO tb_ordendecompra VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orden.getNro());
			pstmt.setInt(2,orden.getEstado());
			pstmt.setString(3,orden.getPrioridad());
			pstmt.setString(4, orden.getFecha());
	
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
	public int actualizar(int nro) {
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
			String sql = "UPDATE tb_ordendecompra SET estado=1 WHERE nro=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nro);
			
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
