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

/**
 * Servlet implementation class ListarSeguro
 */
@WebServlet("/ListarSeguro")
public class ListarSeguro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarSeguro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        SeguroDao seguroDao = new SeguroDao();
        ArrayList<Seguro> listaSeguros = seguroDao.listarSeguros();
        request.setAttribute("listaS", listaSeguros);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarSeguro.jsp");
        dispatcher.forward(request, response);
        

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
