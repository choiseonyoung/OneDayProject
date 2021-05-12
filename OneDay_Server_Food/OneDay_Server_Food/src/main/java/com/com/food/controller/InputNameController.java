package com.com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/insert/name")
public class InputNameController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected FoodService fdService;
	
	public InputNameController() {
		fdService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");

		List<FoodDTO> fdList = fdService.findByName(name);
		req.setAttribute("NAME", fdList);
		req.getRequestDispatcher("/WEB-INF/views/foodList.jsp").forward(req,resp);
	}

}
