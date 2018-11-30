package com.yz.dao;

import com.yz.domain.Orders;
import com.yz.page.QueryInfo;
import com.yz.page.QueryResult;

public interface OrderDao {

	public abstract int seveOrder(Orders order);
 
	public abstract long findSerialNumber(String now);

	public abstract QueryResult findmeOrder(QueryInfo info, String purchaser);

	public abstract void deleteOrder(String ordernumber);

}