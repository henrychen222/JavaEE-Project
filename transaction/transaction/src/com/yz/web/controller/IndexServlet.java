package com.yz.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yz.domain.News;
import com.yz.domain.Product;
import com.yz.service.NewsService;
import com.yz.service.ProductService;
import com.yz.service.impl.NewsServiceImpl;
import com.yz.service.impl.ProductServiceImpl;

public class IndexServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			ProductService service = new ProductServiceImpl();
			NewsService newsService = new NewsServiceImpl();
				List<News> news = newsService.findOne2FiveNews();
				List<Product> products = service.getAllProduct();
				List<Product> productRecomend = service.getProductRecomend();
			request.setAttribute("news", news);
			request.setAttribute("productRecomend", productRecomend);
			request.setAttribute("products", products);
			request.getRequestDispatcher("/WEB-INF/jsp/page/index.jsp").forward(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
