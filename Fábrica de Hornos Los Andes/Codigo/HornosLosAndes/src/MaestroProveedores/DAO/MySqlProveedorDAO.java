package MaestroProveedores.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MaestroProveedores.Beans.ProveedorBean;
import MaestroProveedores.Interfaces.ProveedorDAO;


public class MySqlProveedorDAO implements ProveedorDAO{

	
	@Override
	public ProveedorBean consultarPorCodigo(int codigo) {
		// TODO Auto-generated method stub
		ProveedorBean p = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM proveedores WHERE codigo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			if (rs.next()){
				p = new ProveedorBean();
				p.setCodigo(rs.getInt("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setEmail(rs.getString("email"));
				p.setDireccion(rs.getString("direccion"));
				p.setTelefono(rs.getString("telefono"));
				p.setFechainicio(rs.getString("fechainicio"));
				p.setCiudad(rs.getString("ciudad"));
				p.setEstado(rs.getInt("estado"));
			}			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception e){e.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}
		return p;
	}

	@Override
	public ArrayList<ProveedorBean> consultarTodos() {
		// TODO Auto-generated method stub
		ArrayList<ProveedorBean> lista= new ArrayList<ProveedorBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM proveedores where estado>0";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				ProveedorBean p = new ProveedorBean();
				p.setCodigo(rs.getInt("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setEmail(rs.getString("email"));
				p.setDireccion(rs.getString("direccion"));
				p.setTelefono(rs.getString("telefono"));
				p.setFechainicio(rs.getString("fechainicio"));	
				p.setEstado(rs.getInt("estado"));
				p.setCiudad(rs.getString("ciudad"));
				lista.add(p);
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
	public int eliminarProveedor(int codigo) {
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
			String sql = "UPDATE proveedores SET estado=0 WHERE codigo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			
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
	public int ingresarProveedor(ProveedorBean proveedor) {
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
			String sql = "INSERT INTO proveedores VALUES(?,?,?,?,?,?,?,1)";
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setInt(1, proveedor.getCodigo());
			pstmt.setString(2, proveedor.getNombre());
			pstmt.setString(3, proveedor.getDireccion());
			pstmt.setString(4, proveedor.getTelefono());
			pstmt.setString(5, proveedor.getEmail());
			pstmt.setString(6, proveedor.getCiudad());
			pstmt.setString(7, proveedor.getFechainicio());
			
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
	public int modificarProveedor(ProveedorBean proveedor) {
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
			String sql = "UPDATE proveedores SET nombre=?," +
								"direccion=?, telefono=?, email=?," + 
								"ciudad=? WHERE " +
								"codigo=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, proveedor.getNombre());
			pstmt.setString(2, proveedor.getDireccion());
			pstmt.setString(3, proveedor.getTelefono());
			pstmt.setString(4, proveedor.getEmail());
			pstmt.setString(5, proveedor.getCiudad());
			pstmt.setInt(6, proveedor.getCodigo());
			
			//Paso 4: Se ejecuta la sentencia
			retorno = pstmt.executeUpdate();
		} 
		
		catch(Exception e){
			e.printStackTrace();
		} 		
		finally {
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}
		return retorno;
	}

	@Override
	public ArrayList<ProveedorBean> buscarProveedores(String nombre) {
		// TODO Auto-generated method stub
		ArrayList<ProveedorBean> lista= new ArrayList<ProveedorBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM proveedores WHERE nombre like ? and estado>0";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+nombre+"%");

			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				ProveedorBean p = new ProveedorBean();
				p.setCodigo(rs.getInt("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setEmail(rs.getString("email"));
				p.setDireccion(rs.getString("direccion"));
				p.setTelefono(rs.getString("telefono"));
				p.setFechainicio(rs.getString("fechainicio"));
				p.setEstado(rs.getInt("estado"));
				
				lista.add(p);
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
	public ArrayList<ProveedorBean> consultarCodigos() {
		// TODO Auto-generated method stub
		ArrayList<ProveedorBean> lista= new ArrayList<ProveedorBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM proveedores ";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				ProveedorBean p = new ProveedorBean();
				p.setCodigo(rs.getInt("codigo"));
				p.setNombre(rs.getString("nombre"));
				p.setEmail(rs.getString("email"));
				p.setDireccion(rs.getString("direccion"));
				p.setTelefono(rs.getString("telefono"));
				p.setFechainicio(rs.getString("fechainicio"));	
				p.setEstado(rs.getInt("estado"));
				p.setCiudad(rs.getString("ciudad"));
				lista.add(p);
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
