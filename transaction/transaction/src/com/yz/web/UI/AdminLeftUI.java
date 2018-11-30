package com.yz.web.UI;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLeftUI extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			
			String admin = request.getParameter("admin");
			admin = new String(admin.getBytes("iso-8859-1"),"utf-8");//解决乱码问题  原因：从url中传来的参数都是get方式提交的，都是iso-8859-1的编码，所以需要在得到的时候进行编码转换。
			String id = request.getParameter("id");
			String power=request.getParameter("power");
			request.setAttribute("admin", admin);
			request.setAttribute("id", id);
			request.setAttribute("power", power);
			request.getRequestDispatcher("/WEB-INF/jsp/admin/left.jsp").forward(request, response);
	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
