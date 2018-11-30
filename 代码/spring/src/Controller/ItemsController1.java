package Controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import Item.Items;




public class ItemsController1 implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//调用Service查找数据库,查询商品列表,这里使用静态数据模拟
		List<Items> itemsList = new ArrayList<Items>();
		//向list中填充静态数据
		Items item_1 = new Items();
		item_1.setName("联想笔记本电脑");
		item_1.setPrice(6000f);
		item_1.setDetail("ThinkPad T430联想笔记本电脑");
		
		Items item_2 = new Items();
		item_2.setName("苹果手机");
		item_2.setPrice(5000f);
		item_2.setDetail("ipone6拼过手机");
		
		itemsList.add(item_1);
		itemsList.add(item_2);
		
		//返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//相当于request的setAttribute，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);
		
		//指定视图
		modelAndView.setViewName("/WEB-INF/itemsList.jsp");
		
		return modelAndView;
	}

}
