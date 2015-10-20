package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bussiness.Developer;
import Bussiness.Project;
import Util.StringConstants;

public class HoraDAO extends MysqlCon implements ClassDAO {
	private String sql;
	private ResultSet rs;
	@Override
	public String insert(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response) {
		sql = "select p.* from projeto p "
			 +"inner join tarefa      t  on t.idprojeto = p.idprojeto "
			 +"inner join tarefahoras th on th.idtarefa = t.idtarefa "
			 +"inner join desenvolvedor d on d.iddesenvolvedor = th.iddesenvolvedor "
			 +"where d.iddesenvolvedor = ?";
		Project projeto = new Project();
		Developer dev   =  (Developer) request.getSession().getAttribute(StringConstants.ATTR_LOGIN);
		executeSQL(con, sql);
		try {
			st.setInt(1, dev.getId());
			rs = st.executeQuery();
			while(rs.next()){
				projeto.setId(rs.getInt(StringConstants.ATTR_ID_PROJETO));
				projeto.setNome(rs.getString(StringConstants.ATTR_NOME));
			}
			ArrayList<Project> projetos = new ArrayList<Project>();
			projetos.add(projeto);
			request.setAttribute(StringConstants.ATTR_PROJETOS, projetos);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closeConnect(con, st, null);
		}
		return StringConstants.PATH_AJAX_MAIN;
	}

}
