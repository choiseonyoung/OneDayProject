package com.com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.MyFoodDTO;
import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected FoodService fdService;
	
	public HomeController() {
		fdService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		List<MyFoodDTO> mfList = fdService.selectAll_mf();
		req.setAttribute("MFLIST", mfList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req,resp);
	}
}