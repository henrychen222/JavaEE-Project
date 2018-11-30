package com.yz.admin.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.yz.domain.News;
import com.yz.service.NewsService;
import com.yz.service.impl.NewsServiceImpl;
import com.yz.util.UUIDUtils;

public class NewsManager extends HttpServlet {

	private static final long serialVersionUID = 1L;
	 
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String actionType=request.getParameter("actiontype");
		if("addUI".equals(actionType)){
			
			gotoNewsHome(request,response);
			return;
		}if("add".equals(actionType)){
			
			doAddNews(request,response);
			return ;
		}else if("delete".equals(actionType)){
			doDeleteNews(request, response);
			return;
		}else if("show".equals(actionType)){
			
			doShowNewsDetail(request,response);
			return ;
		}else if("update".equals(actionType)){
			doUpdateNews(request,response);
			return;
		}else if("showAllNews".equals(actionType)){
			doListAllNews(request,response);
			return;
		}else if("showNews".equals(actionType)){
			doShowNews(request,response);
			return;
		}
		
	}
	
	private void doShowNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		NewsService service=new NewsServiceImpl();
		News news=service.findNews(id);
		request.setAttribute("news", news);
		request.getRequestDispatcher("/WEB-INF/jsp/page/showNew.jsp").forward(request, response);
	}

	private void doListAllNews(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		NewsService service =new NewsServiceImpl();
		List<News> list=service.findAllNews();
		request.setAttribute("news", list);
		request.getRequestDispatcher("/WEB-INF/jsp/page/listNews.jsp").forward(request, response);
	}

	private void doShowNewsDetail(HttpServletRequest request,
		HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		NewsService service=new NewsServiceImpl();
		News news=service.findNews(id);
		request.setAttribute("news", news);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/new.jsp").forward(request, response);
		
		
	}

	private void doDeleteNews(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException  {
		request.setCharacterEncoding("utf-8");
		NewsService service=new NewsServiceImpl();
		String id=request.getParameter("id");
		service.deleteNews(id);
		gotoNewsHome(request,response);
		
	}

	private void doAddNews(HttpServletRequest request,
			HttpServletResponse response)  throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		News news=new News();
		String id=UUIDUtils.generateID();
		String admin = request.getParameter("admin");
		admin = new String(admin.getBytes("iso-8859-1"),"utf-8");
		if(id==null||id.equals("")){
        request.setAttribute("message","新闻加载失败");
       
			request.getRequestDispatcher("/WEB-INF/message/message.jsp").forward(request, response);
		return ;
		}
		String title=request.getParameter("title");
		if(title==null||title.equals("")){
			request.setAttribute("message","新闻添加失败" );
			request.getRequestDispatcher("/WEB-INF/message/messgae.jap").forward(request, response);
			return ;
		}
		String content=request.getParameter("content");
		if(content==null||content.equals("")){
			request.setAttribute("message", "新闻添加失败");
			request.getRequestDispatcher("/WEB-INF/message.jsp").forward(request, response);
			return ;
		}
		news.setId(id);
		news.setPublisher(admin);
		news.setTitle(title);
		news.setContent(content);
		NewsService service =new NewsServiceImpl();
		int statue=service.addNew(news);
		if(statue>0){
			gotoNewsHome(request,response);
		}else
		{
			request.setAttribute("message","新闻添加失败");
			request.getRequestDispatcher("/WEB-INF/message/message.jsp").forward(request, response);
			return ;
		}
	}
	private void gotoNewsHome(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException {
	   	request.setCharacterEncoding("utf-8");
	   		
	   	String admin = request.getParameter("admin");
	   	admin = new String(admin.getBytes("iso-8859-1"),"utf-8");
		NewsService service =new NewsServiceImpl();
		List<News> list=service.findAllNews();
		request.setAttribute("admin", admin);
		request.setAttribute("newses", list);
		request.getRequestDispatcher("/WEB-INF/jsp/admin/news.jsp").forward(request, response);
	}
	private void doUpdateNews(HttpServletRequest request,
		HttpServletResponse response) throws IOException {

	News news=new News();
	String id=request.getParameter("id");
	String title=request.getParameter("title");
	if(title==null||title.equals("")){
		response.getWriter().write("error");
		System.out.println("1");
		return ;
	}
	String content=request.getParameter("content");
	if(content==null||content.equals("")){
		response.getWriter().write("error");
		System.out.println("1");
		return ;
	}
	String publisher=request.getParameter("publisher");
	if(publisher==null||publisher.equals("")){
		response.getWriter().write("error");
		System.out.println("1");
		return ;
	}
	news.setId(id);
	news.setPublisher(publisher);
	news.setTitle(title);
	news.setContent(content);
	NewsService service =new NewsServiceImpl();
	service.updateNews(news);
	response.getWriter().write("sucess");
	System.out.println("1");
	return ;
	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
