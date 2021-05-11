package com.com.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.MyFoodVO;
import com.com.food.service.FoodService;
import com.com.food.service.impl.FoodServiceImplV1;

@WebServlet("/insert/name/data")
public class InputDataController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	FoodService fdService;
	
	public InputDataController() {
		fdService = new FoodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fcode = req.getParameter("code");
		req.setAttribute("fcode", fcode);
		req.getRequestDispatcher("/WEB-INF/views/inputData.jsp").forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rootPath = req.getContextPath();
		req.setCharacterEncoding("UTF-8");
		String in_fcode = req.getParameter("fcode");
		String in_date = req.getParameter("in_date");
		String str_in_take = req.getParameter("in_take");
		int in_take = Integer.valueOf(str_in_take);
		MyFoodVO mfVO = new MyFoodVO();
		mfVO.setMf_code(in_fcode);
		mfVO.setMf_date(in_date);
		mfVO.setMf_take(in_take);
		fdService.insert(mfVO);
		resp.sendRedirect(rootPath);
	}
	
}
