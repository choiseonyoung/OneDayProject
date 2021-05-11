package com.com.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/insert/*")
public class InsertController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	protected FoodService fdService;
	
	public InsertController() {
		fdService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/inputName.jsp").forward(req, resp);
	}
	
}