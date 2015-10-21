package com.soberuh.Controller;

import com.soberuh.DAO.ClassDAO;
import com.soberuh.Util.StringConstants;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class DeveloperServlet
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClassDAO newClass = null;
		Command command = null;
		String classDAOPath = StringConstants.PATH_DAO + "." + request.getParameter("classe");
		String commandPath  = StringConstants.PATH_CONTROLLER + "." + request.getParameter("command");
		try {
			newClass = (ClassDAO) Class.forName(classDAOPath).newInstance();
		} catch (Exception e) {
			log("Erro ao criar ClassDAO " + e);
		}
		try{
			command = (Command) Class.forName(commandPath).newInstance();
		}catch(Exception e){
			log("Erro ao criar Command " + e);
		}
		RequestDispatcher action = request.getRequestDispatcher(command.execute(newClass, request, response));
		action.forward(request, response);
	}	

}
