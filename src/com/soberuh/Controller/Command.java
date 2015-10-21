package com.soberuh.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.soberuh.DAO.ClassDAO;

public interface Command {
	public String execute(ClassDAO classe, HttpServletRequest request, HttpServletResponse response);
}
