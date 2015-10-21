package com.soberuh.DAO;

import com.soberuh.Bussiness.Project;
import com.soberuh.Util.StringConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProjectDAO extends MysqlCon implements ClassDAO {
	private String sql;
	@Override
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		sql = "insert into projeto (nome) VALUES (?)";
		Project projeto = new Project();
		projeto.setNome(request.getParameter(StringConstants.ATTR_NOME));
		executeSQL(sql);
		try {
			st.setString(1, projeto.getNome());
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect(st, null);
		}
		
		//TODO Send to the correct webpage. 
		return null;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response) {
		sql = "update projeto set nome = ? where idprojeto = ?";
		int id = Integer.parseInt(request.getParameter(StringConstants.ATTR_ID));
		Project project = new Project();
		project.setNome(request.getParameter(StringConstants.ATTR_NOME));
		executeSQL(sql);
		try {
			st.setString(1, project.getNome());
			st.setInt(2, id);
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect(st, null);
		}
		
		//TODO Send to the correct webpage.
		return null;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		sql = "delete from projeto where idprojeto = ?";
		int id = Integer.parseInt(request.getParameter(StringConstants.ATTR_ID));
		executeSQL(sql);
		try {
			st.setInt(1, id);
			st.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect(st, null);
		}

		//TODO Send to the correct webpage.
		return null;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response) {
		sql = "select * from projeto";
		ResultSet rs;
		ArrayList<Project> projetos = new ArrayList<Project>();
		executeSQL(sql);
		try {
			rs = st.executeQuery();		
			while(rs.next()){
				Project projeto = new Project();
				projeto.setNome(rs.getString(StringConstants.ATTR_NOME));
				projeto.setId(rs.getInt(StringConstants.ATTR_ID_PROJETO));
				projetos.add(projeto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect(st, null);
		}
		request.setAttribute(StringConstants.ATTR_PROJETOS, projetos);
		return StringConstants.PATH_AJAX_MAIN;
	}

}
