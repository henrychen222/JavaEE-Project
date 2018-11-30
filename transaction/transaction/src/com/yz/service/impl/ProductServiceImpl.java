package com.yz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yz.dao.ProductDao;
import com.yz.dao.impl.ProductDaoImpl;
import com.yz.domain.Product;
import com.yz.domain.ProductType;
import com.yz.page.PageBean;
import com.yz.page.QueryInfo;
import com.yz.page.QueryResult;
import com.yz.service.ProductService;

public class ProductServiceImpl implements ProductService {
	ProductDao dao=null;
	
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#addProduct(com.yz.domain.Product)
	 */
	public int addProduct(Product product)
	{
		
		dao=new ProductDaoImpl();
		return dao.addProduct(product);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#getAllProduct()
	 */
	public List<Product> getAllProduct() 
	{
		dao=new ProductDaoImpl();
		return dao.getAllProduct();
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#getUserProduct()
	 */
	//获得用户发布的所有闲置商品
	public PageBean getUserProduct(QueryInfo info, String username)
	{
		dao=new ProductDaoImpl();
		QueryResult qr = dao.getUserProduct(info,username);
		PageBean bean = new PageBean();
			bean.setCurrentpage(info.getCurrentpage());
			bean.setList(qr.getList());
			bean.setPagesize(info.getPagesize());
			bean.setTotalrecord(qr.getTotalrecord());
		return bean;
		
	}
	
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#getAllProductType()
	 */
	public List<ProductType> getAllProductType() 
	{
		dao=new ProductDaoImpl();
		return dao.getAllProductType();
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#delete()
	 */
	public void delete(String id) 
	{
		dao=new ProductDaoImpl();
		dao.delete(id);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#update()
	 */
	public void update(Product product) 
	{
		dao=new ProductDaoImpl();
		dao.update(product);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#updateClickcount()
	 */
	public void updateClickcount(int clickcount,String id){
		dao=new ProductDaoImpl();
		dao.updateClickcount(clickcount,id);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#find()
	 */
	public Product find(String id)
	{
		dao=new ProductDaoImpl();
		return dao.find(id);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#findCategoryID()
	 */
	public  int findCategoryID(String category){
		dao=new ProductDaoImpl();
		return dao.findCategoryID(category);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#seavePath()
	 */
	public int seavePath(String path){
		dao=new ProductDaoImpl();
		return dao.seavePath(path);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#findTwoLevelIdByPid()
	 */
	public ArrayList<Integer> findTwoLevelIdByPid(int pid){
		dao=new ProductDaoImpl();
		return dao.findTwoLevelIdByPid(pid);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#findThreeLevelIdByPid()
	 */
	public ArrayList<Integer> findThreeLevelIdByPid(ArrayList<Integer> list){
		dao=new ProductDaoImpl();
		return dao.findThreeLevelIdByPid(list);
	}
	public ProductType findThreeLevelNameById(String categoryID){
		dao=new ProductDaoImpl();
		return dao.findThreeLevelNameById(categoryID);
	}
	public ArrayList<ProductType> findSecondLevelNameByid(ArrayList<Integer> list,ArrayList<Integer> list2){
		dao=new ProductDaoImpl();
		return dao.findSecondLevelNameByid(list,list2);
	}
	public ArrayList<ProductType> findThreeLevelNameBypid(String id){
		dao=new ProductDaoImpl();
		return dao.findThreeLevelNameBypid(id);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#findOneLevelAllProducts()
	 */
	public PageBean findOneLevelAllProducts(QueryInfo info, ArrayList<Integer> list2){
		dao=new ProductDaoImpl();
		QueryResult qr = dao.findOneLevelAllProducts(info,list2);
		 PageBean bean = new PageBean();
			bean.setCurrentpage(info.getCurrentpage());
			bean.setList(qr.getList());
			bean.setPagesize(info.getPagesize());
			bean.setTotalrecord(qr.getTotalrecord());
		return bean;
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#findTypeName()
	 */
	public ProductType findUpOneLevelName(String categoryID){
		dao=new ProductDaoImpl();
		return dao.findUpOneLevelName(categoryID);
	}
	public String findSecondLevelName(String id){
		dao=new ProductDaoImpl();
		return dao.findSecondLevelName(id);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#findByCategoryID()
	 */
	public PageBean findThreeLevelProducts(QueryInfo info, String categoryID){
		dao=new ProductDaoImpl();
		QueryResult qr = dao.findThreeLevelProducts(info,categoryID);
		 PageBean bean = new PageBean();
			bean.setCurrentpage(info.getCurrentpage());
			bean.setList(qr.getList());
			bean.setPagesize(info.getPagesize());
			bean.setTotalrecord(qr.getTotalrecord());
		return bean;
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#findOneLevelNameByid()
	 */
	public String findOneLevelNameByid(int id){
		dao=new ProductDaoImpl();
		return dao.findOneLevelNameByid(id);
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#searchProduct()
	 */
	public PageBean searchProduct(QueryInfo info,String search){
		dao=new ProductDaoImpl();
		QueryResult qr = dao.searchProduct(info,search);
		 PageBean bean = new PageBean();
			bean.setCurrentpage(info.getCurrentpage());
			bean.setList(qr.getList());
			bean.setPagesize(info.getPagesize());
			bean.setTotalrecord(qr.getTotalrecord());
		return bean;
	}
	/* (non-Javadoc)
	 * @see com.yz.service.impl.ProductService#addProductType()
	 */
	public void addProductType(ProductType producttype) {
		// TODO Auto-generated method stub
		
	}
	
	public int addCollect(String productId, String userId) {
		
		dao=new ProductDaoImpl();
		return dao.addCollect(productId,userId);
		
	}
	public int findCollect(String productId, String userid) {

		dao=new ProductDaoImpl();
		return dao.findCollect(productId,userid);
	}
	public int deleteCollect(String productId) {
		
		dao=new ProductDaoImpl();
		return dao.deleteCollect(productId);
	}
	public int soldOUt(String id) {
		
		dao=new ProductDaoImpl();
		return dao.soldOut(id);
	}
	
	//获得已经下架的商品
	public PageBean getUserSoldOutProduct(QueryInfo info, String username) {


		dao=new ProductDaoImpl();
		QueryResult qr = dao.getUserSoldOutProduct(info,username);
		PageBean bean = new PageBean();
			bean.setCurrentpage(info.getCurrentpage());
			bean.setList(qr.getList());
			bean.setPagesize(info.getPagesize());
			bean.setTotalrecord(qr.getTotalrecord());
		return bean;
	}
	public int deleteSoldOUt(String id) {

		dao=new ProductDaoImpl();
		return dao.deleteSoldOUt(id);
	}
	public void setPurchaserIntoProduct(String id,String purchaser) {

		dao=new ProductDaoImpl();
		dao.setPurchaserIntoProduct(id,purchaser);
		
	}
	public void updateProductRecomend(String id) {
		dao=new ProductDaoImpl();
		dao.updateProductRecomend(id);
		
	}
	public List<Product> getProductRecomend(){
		dao=new ProductDaoImpl();
		return dao.getProductRecomend();
	}
	
}
