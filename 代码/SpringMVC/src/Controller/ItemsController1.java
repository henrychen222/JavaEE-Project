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
		
		//����Service�������ݿ�,��ѯ��Ʒ�б�,����ʹ�þ�̬����ģ��
		List<Items> itemsList = new ArrayList<Items>();
		//��list����侲̬����
		Items item_1 = new Items();
		item_1.setName("����ʼǱ�����");
		item_1.setPrice(6000f);
		item_1.setDetail("ThinkPad T430����ʼǱ�����");
		
		Items item_2 = new Items();
		item_2.setName("ƻ���ֻ�");
		item_2.setPrice(5000f);
		item_2.setDetail("ipone6ƴ���ֻ�");
		
		itemsList.add(item_1);
		itemsList.add(item_2);
		
		//����ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		//�൱��request��setAttribute����jspҳ����ͨ��itemsListȡ����
		modelAndView.addObject("itemsList", itemsList);
		
		//ָ����ͼ
		modelAndView.setViewName("/WEB-INF/itemsList.jsp");
		
		return modelAndView;
	}

}
