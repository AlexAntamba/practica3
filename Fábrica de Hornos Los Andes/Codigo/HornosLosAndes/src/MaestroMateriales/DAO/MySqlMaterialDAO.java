package MaestroMateriales.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MaestroMateriales.Beans.MaterialBean;
import MaestroMateriales.Interfaces.MaterialDAO;

public class MySqlMaterialDAO implements MaterialDAO {
	
	@Override
	public MaterialBean consultarPorCodigo(int codigo) {
		MaterialBean m = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM materiales WHERE codigo=? and estado=1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			if (rs.next()){
				m = new MaterialBean();
				m.setCodigo(rs.getInt("codigo"));
				m.setNombre(rs.getString("nombre"));
				m.setTipo(rs.getString("tipo"));
				m.setDurabilidad(rs.getString("durabilidad"));
				m.setFecreg(rs.getString("fecreg"));
				m.setDetuso(rs.getString("detuso"));
				m.setStock(rs.getInt("stock"));
			}			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception e){e.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}
		return m;
	}

	@Override
	public ArrayList<MaterialBean> consultarTodos() {
		ArrayList<MaterialBean> lista= new ArrayList<MaterialBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM materiales WHERE estado=1";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				MaterialBean m = new MaterialBean();
				m.setCodigo(rs.getInt("codigo"));
				m.setNombre(rs.getString("nombre"));
				m.setTipo(rs.getString("tipo"));
				m.setDurabilidad(rs.getString("durabilidad"));
				m.setFecreg(rs.getString("fecreg"));
				m.setDetuso(rs.getString("detuso"));
				m.setStock(rs.getInt("stock"));
				
				lista.add(m);
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
	public int eliminarMaterial(int codigo) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "UPDATE materiales SET estado=0 WHERE codigo=?";
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
	public int ingresarMaterial(MaterialBean Material) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "INSERT INTO materiales VALUES(?,?,?,?,?,?,?,1)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Material.getCodigo());
			pstmt.setString(2, Material.getNombre());
			pstmt.setString(3, Material.getTipo());
			pstmt.setString(4, Material.getDurabilidad());
			pstmt.setString(5, Material.getFecreg());
			pstmt.setString(6, Material.getDetuso());
			pstmt.setInt(7, Material.getStock());	
			
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
	public int modificarMaterial(MaterialBean Material) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "UPDATE materiales SET nombre=?," +
								"tipo=?, durabilidad=?," + 
								"detuso=?, stock=? WHERE " +
								"codigo=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Material.getNombre());
			pstmt.setString(2, Material.getTipo());
			pstmt.setString(3, Material.getDurabilidad());
			pstmt.setString(4, Material.getDetuso());
			pstmt.setInt(5, Material.getStock());	
			pstmt.setInt(6, Material.getCodigo());
			
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
	public ArrayList<MaterialBean> buscarMateriales(String nombre, String tipo) {
		ArrayList<MaterialBean> lista= new ArrayList<MaterialBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM materiales WHERE nombre like ? and tipo like ? and estado=1";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+nombre+"%");
			pstmt.setString(2, "%"+tipo+"%");
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				MaterialBean m = new MaterialBean();
				m.setCodigo(rs.getInt("codigo"));
				m.setNombre(rs.getString("nombre"));
				m.setTipo(rs.getString("tipo"));
				m.setDurabilidad(rs.getString("durabilidad"));
				m.setFecreg(rs.getString("fecreg"));
				m.setDetuso(rs.getString("detuso"));
				m.setStock(rs.getInt("stock"));
				
				lista.add(m);
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
	public ArrayList<MaterialBean> consultarCodigos() {
		// TODO Auto-generated method stub
		ArrayList<MaterialBean> lista= new ArrayList<MaterialBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM materiales";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				MaterialBean m = new MaterialBean();
				m.setCodigo(rs.getInt("codigo"));
				m.setNombre(rs.getString("nombre"));
				m.setTipo(rs.getString("tipo"));
				m.setDurabilidad(rs.getString("durabilidad"));
				m.setFecreg(rs.getString("fecreg"));
				m.setDetuso(rs.getString("detuso"));
				m.setStock(rs.getInt("stock"));
				
				lista.add(m);
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
