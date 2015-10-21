package com.soberuh.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ClassDAO {
	public String insert(HttpServletRequest request, HttpServletResponse response);
	public String update(HttpServletRequest request, HttpServletResponse response);
	public String delete(HttpServletRequest request, HttpServletResponse response);
	public String list(HttpServletRequest request, HttpServletResponse response);
}
