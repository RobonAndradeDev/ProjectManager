

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.MysqlCon;


public class MysqlConServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		System.out.println("veio e " + request.getParameter("shitText") );
		RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
		rd.forward(request,response);
		
	}
	/*
    public MysqlConServlet() throws SQLException {
    	  closeConnetion(getConnection());    	  
    	  
    }
    
    public Connection getConnection(){
    	return new MysqlCon().getConnection();
    }
    
    public void closeConnetion(Connection con) throws SQLException{
    	new MysqlCon().closeConnect(con);
    }
    */
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
