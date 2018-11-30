package com.yz.dao;

import java.util.ArrayList;
import java.util.List;

import com.yz.domain.Product;
import com.yz.domain.ProductType;
import com.yz.page.QueryInfo;
import com.yz.page.QueryResult;

public interface ProductDao {

	public abstract int addProduct(Product product);
 
	public abstract List<Product> getAllProduct();

	public abstract List<ProductType> getAllProductType();
	
	public abstract  void delete(String id);
	
	public abstract  void update(Product product); 

	public abstract void updateClickcount(int clickcount, String id);
	
	public abstract  Product find(String id);

	public abstract int findCategoryID(String category);

	public abstract int seavePath(String path);

	public abstract ArrayList<Integer> findTwoLevelIdByPid(int pid);

	public abstract ArrayList<Integer> findThreeLevelIdByPid(ArrayList<Integer> list);

	public abstract ProductType findThreeLevelNameById(String categoryID);
	
	public abstract QueryResult findOneLevelAllProducts(QueryInfo info, ArrayList<Integer> list2);

	public abstract ProductType findUpOneLevelName(String categoryID);

	public abstract String findSecondLevelName(String id);
	
	public abstract QueryResult findThreeLevelProducts(QueryInfo info, String categoryID);

	public abstract String findOneLevelNameByid(int id);

	public abstract QueryResult searchProduct(QueryInfo info, String search);

	public abstract QueryResult getUserProduct(QueryInfo info, String username);

	public abstract int addCollect(String productId, String userId);

	public abstract int findCollect(String productId, String userid);

	public abstract ArrayList<ProductType> findSecondLevelNameByid(ArrayList<Integer> list,ArrayList<Integer> list2);

	public abstract ArrayList<ProductType> findThreeLevelNameBypid(String id);
	
	public abstract int deleteCollect(String productId);

	public abstract int soldOut(String id);

	public abstract QueryResult getUserSoldOutProduct(QueryInfo info,String username);

	public abstract int deleteSoldOUt(String id);

	public abstract void setPurchaserIntoProduct(String id,String purchaser);

	public abstract void updateProductRecomend(String id);

	public abstract List<Product> getProductRecomend();


}