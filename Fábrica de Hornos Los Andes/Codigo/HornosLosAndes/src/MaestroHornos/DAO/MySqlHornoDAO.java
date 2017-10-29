package MaestroHornos.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import MaestroHornos.Beans.HornoBean;
import MaestroHornos.Interfaces.HornoDAO;

public class MySqlHornoDAO implements HornoDAO {
	
	@Override
	public HornoBean consultarPorCodigo(int codigo) {
		HornoBean h = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM hornos WHERE codigo=? and estado=1";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, codigo);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			if (rs.next()){
				h = new HornoBean();
				h.setCodigo(rs.getInt("codigo"));
				h.setModelo(rs.getString("modelo"));
				h.setGarantia(rs.getString("garantia"));
				h.setDescripcion(rs.getString("descripcion"));
				h.setFecreg(rs.getString("fecreg"));
				h.setDimensiones(rs.getString("dimensiones"));
				h.setStock(rs.getInt("stock"));
				h.setPrecio(rs.getDouble("precio"));
			}			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//Paso 6: Se cierran los objetos de conexión
			try{ if (rs!=null) rs.close();} catch(Exception e){e.printStackTrace();}
			try{ if (pstmt!=null) pstmt.close();} catch(Exception e){e.printStackTrace();}
			try{ if (conn!=null) conn.close();} catch(Exception e){e.printStackTrace();}
		}
		return h;
	}

	@Override
	public ArrayList<HornoBean> consultarTodos() {
		ArrayList<HornoBean> lista= new ArrayList<HornoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM hornos WHERE estado=1";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				HornoBean h = new HornoBean();
				h.setCodigo(rs.getInt("codigo"));
				h.setModelo(rs.getString("modelo"));
				h.setGarantia(rs.getString("garantia"));
				h.setDescripcion(rs.getString("descripcion"));
				h.setFecreg(rs.getString("fecreg"));
				h.setDimensiones(rs.getString("dimensiones"));
				h.setStock(rs.getInt("stock"));
				h.setPrecio(rs.getDouble("precio"));
				
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
	public int eliminarHorno(int codigo) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "UPDATE hornos SET estado=0 WHERE codigo=?";
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
	public int ingresarHorno(HornoBean Horno) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "INSERT INTO hornos VALUES(?,?,?,?,?,?,?,?,1)";
			pstmt = conn.prepareStatement(sql);
						
			pstmt.setInt(1, Horno.getCodigo());
			pstmt.setString(2, Horno.getModelo());
			pstmt.setString(3, Horno.getGarantia());
			pstmt.setString(4, Horno.getDescripcion());
			pstmt.setString(5, Horno.getFecreg());
			pstmt.setString(6, Horno.getDimensiones());
			pstmt.setInt(7, Horno.getStock());	
			pstmt.setDouble(8, Horno.getPrecio());
			
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
	public int modificarHorno(HornoBean Horno) {
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "UPDATE hornos SET modelo=?," +
								"garantia=?, descripcion=?, " + 
								"dimensiones=?, stock=?, precio=? WHERE " +
								"codigo=?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, Horno.getModelo());
			pstmt.setString(2, Horno.getGarantia());
			pstmt.setString(3, Horno.getDescripcion());
			pstmt.setString(4, Horno.getDimensiones());
			pstmt.setInt(5, Horno.getStock());	
			pstmt.setDouble(6, Horno.getPrecio());
			pstmt.setInt(7, Horno.getCodigo());
			
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
	public ArrayList<HornoBean> buscarHornos(String modelo) {
		ArrayList<HornoBean> lista= new ArrayList<HornoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM hornos WHERE modelo like ? and estado=1";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "%"+modelo+"%");

			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				HornoBean h = new HornoBean();
				h.setCodigo(rs.getInt("codigo"));
				h.setModelo(rs.getString("modelo"));
				h.setGarantia(rs.getString("garantia"));
				h.setDescripcion(rs.getString("descripcion"));
				h.setFecreg(rs.getString("fecreg"));
				h.setDimensiones(rs.getString("dimensiones"));
				h.setStock(rs.getInt("stock"));
				h.setPrecio(rs.getDouble("precio"));
				
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
	public ArrayList<HornoBean> consultarCodigos() {
		// TODO Auto-generated method stub
		ArrayList<HornoBean> lista= new ArrayList<HornoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM hornos ";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				HornoBean h = new HornoBean();
				h.setCodigo(rs.getInt("codigo"));
				h.setModelo(rs.getString("modelo"));
				h.setGarantia(rs.getString("garantia"));
				h.setDescripcion(rs.getString("descripcion"));
				h.setFecreg(rs.getString("fecreg"));
				h.setDimensiones(rs.getString("dimensiones"));
				h.setStock(rs.getInt("stock"));
				h.setPrecio(rs.getDouble("precio"));
				
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
	public int actualizarStock(int codigo, int cantidad) {
		// TODO Auto-generated method stub
		HornoBean horno = consultarPorCodigo(codigo);
		int stock=horno.getStock()-cantidad;
		int retorno = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "UPDATE hornos SET stock=? WHERE codigo=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stock);
			pstmt.setInt(2, codigo);
			
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
	public ArrayList<HornoBean> listarTodos() {
		// TODO Auto-generated method stub
		ArrayList<HornoBean> lista= new ArrayList<HornoBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Paso 1: Registrar el driver		
			Class.forName("com.mysql.jdbc.Driver");
			//Paso 2: Se obtiene la conexión
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/losandes", "root", "mysql");			
			//Paso 3: Se prepara la sentencia
			String sql = "SELECT * FROM hornos WHERE estado=1 and stock>0";
			pstmt = conn.prepareStatement(sql);
			
			//Paso 4: Se ejecuta la sentencia
			rs = pstmt.executeQuery();
			
			//Paso 5: Se evalúa el resultado
			while (rs.next()){
				HornoBean h = new HornoBean();
				h.setCodigo(rs.getInt("codigo"));
				h.setModelo(rs.getString("modelo"));
				h.setGarantia(rs.getString("garantia"));
				h.setDescripcion(rs.getString("descripcion"));
				h.setFecreg(rs.getString("fecreg"));
				h.setDimensiones(rs.getString("dimensiones"));
				h.setStock(rs.getInt("stock"));
				h.setPrecio(rs.getDouble("precio"));
				
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
