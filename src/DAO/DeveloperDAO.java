package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Util.StringConstants;
import Bussiness.Developer;

public class DeveloperDAO extends MysqlCon implements ClassDAO {
	private String sql;
	
	@Override
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		sql = "insert into desenvolvedor (nome, email, senha) VALUES (?, ?, ?)";
		Developer dev = new Developer();
		dev.setNome(request.getParameter(StringConstants.ATTR_NOME));
		dev.setEmail(request.getParameter(StringConstants.ATTR_EMAIL));
		dev.setSenha(request.getParameter(StringConstants.ATTR_SENHA));
		executeSQL(con, sql);
		try {
			st.setString(1, dev.getNome());
			st.setString(2, dev.getEmail());
			st.setString(3, dev.getSenha());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeConnect(con, st, null);
		}
		
		// TODO Send to the correct webpage.
		return null;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response) {
		sql = "update desenvolvedor set senha = ? " 
			 +"where iddesenvolvedor = ?";
		String senha = (String)request.getParameter(StringConstants.ATTR_SENHA);
		String id = (String)request.getParameter(StringConstants.ATTR_ID);
		executeSQL(con, sql);
		try {
			st.setString(1, senha);
			st.setString(2, id);
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect(con, st, null);
		}
		
		//TODO Send to the correct webpage.
		return null;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		sql = "delete from desenvolvedor where iddesenvolvedor = ?";
		String id = (String)request.getParameter(StringConstants.ATTR_ID);
		executeSQL(con, sql);
		try {
			st.setString(1, id);
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect(con, st, null);
		}
		
		//TODO Send to the correct webpage.
		return null;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response) {
		con = getConnection();
		sql = "select * from desenvolvedor d "
			 +"where d.email = ? "
			 +"and d.senha = ?";
		ResultSet rs = null;
		Developer dev = new Developer();
		String path = StringConstants.PATH_INDEX;
		dev.setEmail(request.getParameter(StringConstants.ATTR_EMAIL));
		dev.setSenha(request.getParameter(StringConstants.ATTR_SENHA));
		executeSQL(con, sql);
		try {
			st.setString(1, dev.getEmail());
			st.setString(2, dev.getSenha());
			rs = st.executeQuery();
			if(rs.next()){
				dev.setNome(rs.getString(StringConstants.ATTR_NOME));
				dev.setId(rs.getInt(StringConstants.ATTR_ID_DESENVOLVEDOR));
			}else{
				dev = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect(con, st, rs);
		}
		request.getSession().setAttribute(StringConstants.ATTR_LOGIN, dev);
		request.setAttribute(StringConstants.ATTR_FIRST_TIME, true);
		if(dev != null){
			path = StringConstants.PATH_MAIN;
		}
		return path;
	}
	
	
}
