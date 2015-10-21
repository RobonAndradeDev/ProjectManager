package com.soberuh.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soberuh.DAO.ClassDAO;

public class update implements Command {

	@Override
	public String execute(ClassDAO classe, HttpServletRequest request, HttpServletResponse response) {
		return classe.update(request, response);
	}

}
