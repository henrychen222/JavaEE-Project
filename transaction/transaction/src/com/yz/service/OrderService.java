package com.yz.service;

import com.yz.domain.Orders;
import com.yz.page.PageBean;
import com.yz.page.QueryInfo;

public interface OrderService {

	public abstract int seveOrder(Orders order);

	public abstract long findSerialNumber(String now);

	public abstract PageBean findmeOrder(QueryInfo info, String purchaser);

	public abstract void deleteOrder(String ordernumber);

} 