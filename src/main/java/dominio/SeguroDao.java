package dominio;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SeguroDao {
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "segurosgroup";
	
	public int obtenerUltimoIdUsuario() {
	    int ultimoId = -1;
	    Connection con = null;

	    try {
	        con = DriverManager.getConnection(host + dbName, user, pass);
	        PreparedStatement st = con.prepareStatement("SELECT MAX(idSeguro) FROM seguros");
	        ResultSet rs = st.executeQuery();

	        if (rs.next()) {
	            ultimoId = rs.getInt(1);
	        }

	        con.close();
	    } catch (Exception e) {
	        System.out.println("Error al obtener el último ID: " + e.getMessage());
	    }

	    return ultimoId;
	}
	
	
	public boolean agregarSeguro(Seguro seguro) {
	    Connection con = null;
	    boolean exito = false;
	    
	    try {
	        con = DriverManager.getConnection(host + dbName, user, pass);
	        String sql = "INSERT INTO seguros (descripcion, idTipo, costoContratacion, costoAsegurado) VALUES (?, ?, ?, ?)";
	        
	        PreparedStatement st = con.prepareStatement(sql);
	        st.setString(1, seguro.getDescripcion());
	        st.setInt(2, seguro.getIdtipo());
	        st.setFloat(3, seguro.getCostoContracion());
	        st.setFloat(4, seguro.getCostoAsegurado());
	        
	        int filasAfectadas = st.executeUpdate();
	        exito = (filasAfectadas > 0);
	        
	    } catch (Exception e) {
	        System.out.println("Error al agregar seguro: " + e.getMessage());
	    } finally {
	        if (con != null) {
	            try { con.close(); } catch (Exception e) { e.printStackTrace(); }
	        }
	    }
	    return exito;
	}
	
	public ArrayList<Seguro> listarSeguros(){
		 try {
	         Class.forName("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException var6) {
	         var6.printStackTrace();
	      }

	      ArrayList<Seguro> lista = new ArrayList<Seguro>();
	      Connection conn = null;

	      try {
	         conn = DriverManager.getConnection(this.host + this.dbName, this.user, this.pass);
	         Statement st = conn.createStatement();
	         ResultSet rs = st.executeQuery("Select idSeguro, descripcion, idTipo, costoContratacion, costoAsegurado FROM seguros");

	         while(rs.next()) {
	            Seguro seguros = new Seguro();
	            seguros.setId(rs.getInt("idSeguro"));
	            seguros.setDescripcion(rs.getString("descripcion"));
	            seguros.setIdtipo(rs.getInt("idTipo"));
	            seguros.setCostoContracion(rs.getFloat("costoContratacion"));
	            seguros.setCostoAsegurado(rs.getFloat("costoAsegurado"));
	            lista.add(seguros);
	         }

	         conn.close();
	      } catch (Exception var7) {
	         var7.printStackTrace();
	      }

	      return lista;
		
	}
	
}