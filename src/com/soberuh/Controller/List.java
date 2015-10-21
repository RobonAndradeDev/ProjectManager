package com.soberuh.Controller;

import com.soberuh.DAO.ClassDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List implements Command {

	@Override
	public String execute(ClassDAO classe, HttpServletRequest request, HttpServletResponse response) {
		return classe.list(request, response);
	}


}
