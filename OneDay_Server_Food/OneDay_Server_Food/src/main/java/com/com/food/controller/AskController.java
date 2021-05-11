package com.com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.MyFoodDTO;
import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/ask")
public class AskController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected FoodService fService;

	public AskController() {
		fService = new FoodServiceImplV1();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String date = req.getParameter("date");

		List<MyFoodDTO> mfList = fService.findByDate(date);

		ServletContext app = this.getServletContext();

		app.setAttribute("DATE", mfList);

		RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/dateList.jsp");

		disp.forward(req, resp);
	}
}

//}
