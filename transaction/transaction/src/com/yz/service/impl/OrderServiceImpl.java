package com.yz.service.impl;

import com.yz.dao.OrderDao;
import com.yz.dao.impl.OrderDaoImpl;
import com.yz.domain.Orders;
import com.yz.page.PageBean;
import com.yz.page.QueryInfo;
import com.yz.page.QueryResult;
import com.yz.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao dao = null;
	
	/* (non-Javadoc)
	 * @see com.yz.service.impl.OrderService#seveOrder(com.yz.domain.Orders)
	 */
	public int seveOrder(Orders order){
		dao = new OrderDaoImpl();
		return dao.seveOrder(order);
	}
	public long findSerialNumber(String now){
		dao = new OrderDaoImpl();
		return dao.findSerialNumber(now);
	}
	public PageBean findmeOrder(QueryInfo info, String purchaser){
		dao = new OrderDaoImpl();
		QueryResult qr = dao.findmeOrder(info,purchaser);
			PageBean bean = new PageBean();
			bean.setCurrentpage(info.getCurrentpage());
			bean.setList(qr.getList());
			bean.setPagesize(info.getPagesize());
			bean.setTotalrecord(qr.getTotalrecord());
		return bean;
	}
	public void deleteOrder(String ordernumber) {

		dao = new OrderDaoImpl();
		 dao.deleteOrder(ordernumber);
	}
	
	
}
