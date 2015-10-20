package Controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.StringConstants;

import DAO.ClassDAO;


/**
 * Servlet implementation class DeveloperServlet
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassDAO classe = null;
		Command command = null;
		String classDAOPath = StringConstants.PATH_DAO + "." + request.getParameter("classe");
		String commandPath  = StringConstants.PATH_CONTROLLER + "." + request.getParameter("command");
		try {
			classe = (ClassDAO) Class.forName(classDAOPath).newInstance();
		} catch (Exception e) {
			log("Erro ao criar ClassDAO " + e);
		}
		try{
			command = (Command) Class.forName(commandPath).newInstance();
		}catch(Exception e){
			log("Erro ao criar Command " + e);
		}
		RequestDispatcher action = request.getRequestDispatcher(command.execute(classe, request, response));
		action.forward(request, response);
	}	

}
