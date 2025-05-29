package ServLets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Seguro;
import dominio.SeguroDao;
import dominio.TipoSeguros;
import dominio.TipoSegurosDao;

/**
 * Servlet implementation class AgregarSeguro
 */
@WebServlet("/AgregarSeguro")
public class AgregarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgregarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TipoSegurosDao tipoSegurosDao = new TipoSegurosDao();
	    ArrayList<TipoSeguros> listaTipoSeguros = tipoSegurosDao.obtenerTipoSeguros();
	    request.setAttribute("listaTipoSeguros", listaTipoSeguros);
	    
	    SeguroDao seguroDao = new SeguroDao();
	    int ultimoId = seguroDao.obtenerUltimoIdUsuario();
	    int siguienteId = ultimoId + 1;
	    request.setAttribute("siguienteId", siguienteId);
	    
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher("AgregarSeguro.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnAceptar")!=null) {
			String descripcion = request.getParameter("txtDescripcion");
		    String tipoSeguroStr = request.getParameter("tipoSeguro");
		    String costoContratacionStr = request.getParameter("txtCostocontratacion");
		    String costoAseguradoStr = request.getParameter("txtCostomaximo");
		    
		   
		    if (descripcion.isEmpty() || tipoSeguroStr.isEmpty() || costoContratacionStr.isEmpty() || costoAseguradoStr.isEmpty()) {
		        request.setAttribute("error", "Todos los campos son obligatorios");
		        doGet(request, response); 
		        return;
		    }
		    
		    try {
		        
		        int idTipo = Integer.parseInt(tipoSeguroStr);
		        float costoContratacion = Float.parseFloat(costoContratacionStr);
		        float costoAsegurado = Float.parseFloat(costoAseguradoStr);
		        
		        
		        Seguro nuevoSeguro = new Seguro(0, descripcion, idTipo, costoContratacion, costoAsegurado);
		        SeguroDao seguroDao = new SeguroDao();
		        boolean Filas = seguroDao.agregarSeguro(nuevoSeguro);
		        
		        if (Filas) {
		            response.sendRedirect("ListarSeguro"); 
		        } else {
		            request.setAttribute("error", "Error al guardar el seguro");
		            doGet(request, response);
		        }
		        
		    } catch (NumberFormatException e) {
		        request.setAttribute("error", "Formato inválido en números");
		        doGet(request, response);
		    }
		}
		
	}

}
