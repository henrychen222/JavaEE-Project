package com.zbiti.iepe.framework.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrServer;
import org.apache.solr.client.solrj.response.GroupResponse;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.GroupParams;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import com.zbiti.iepe.es.ESClientInstance;
import com.zbiti.iepe.es.ESOperator;
import com.zbiti.iepe.framework.model.BaseUser;

 public class ProductUtil  implements ApplicationListener<ContextRefreshedEvent>{
	 
	 
	 public static CloudSolrServer cloudSolrServer; 
	 
	 public static Map sizeMap;
	 
	 public static Map priceMap;
	 
	 public static Map freeMap;
	 
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getParent() == null){
			ClassPathResource resource = new ClassPathResource("iepe.properties");
			try {
				Properties props = PropertiesLoaderUtils.loadProperties(resource);
				String href=props.getProperty("solr.href");
				Integer zkClientTimeout=Integer.valueOf(props.getProperty("solr.zkClientTimeout"));
				Integer zkConnectTimeout=Integer.valueOf(props.getProperty("solr.zkConnectTimeout"));
				cloudSolrServer=getCloudSolrServer(href);
				cloudSolrServer.setZkClientTimeout(zkClientTimeout); 
				cloudSolrServer.setZkConnectTimeout(zkConnectTimeout); 
		//	cloudSolrServer.connect();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			jhProductMaintainDao.execProcdure();
//			sizeMap=new HashMap();
//			priceMap=new HashMap();
//			freeMap=new HashMap();
//			getSizeAll(sizeMap);
//			JhSize size=new JhSize();
//			size.setIsPriceStrategy(61);
//			getSizeMap(priceMap,size);
//			size.setIsPriceStrategy(60);
//			getSizeMap(freeMap,size);
			
			 
	   	}
	}

	 public static  CloudSolrServer getCloudSolrServer(final String zkHost) { 
		 if(cloudSolrServer == null) { 
		 try { 
		 cloudSolrServer = new CloudSolrServer(zkHost); 
		 }catch(Exception e) { 
		 e.printStackTrace(); 
		 } 
		 } 
	
		 return cloudSolrServer; 
	 } 
	 
	 public static void deleteData(String id){
		 try {
			ProductUtil.cloudSolrServer.setDefaultCollection("product");
			ProductUtil.cloudSolrServer.deleteByQuery("id:"+id);// delete everything! 
			ProductUtil.cloudSolrServer.commit(); 
			 }catch(SolrServerException e){ 
				 e.printStackTrace(); 
			 }catch(IOException e) { 
				 e.printStackTrace(); 
			 }catch(Exception e) { 
				 System.out.println("Unknowned Exception !!!!"); 
				 e.printStackTrace(); 
			 } 
	 }
	
	public synchronized void getSizeAll(Map sizeMap){
	}
	
	
	 public static String captureName(String name) {
	        name = name.substring(0, 1).toUpperCase() + name.substring(1);
	       return  name;
	    }
	 public static void deleteDataByCompanyId(Object id){
		 try {
			ProductUtil.cloudSolrServer.setDefaultCollection("product");
			ProductUtil.cloudSolrServer.deleteByQuery("companyId:"+id);// delete everything! 
			ProductUtil.cloudSolrServer.commit(); 
			 }catch(SolrServerException e){ 
				 e.printStackTrace(); 
			 }catch(IOException e) { 
				 e.printStackTrace(); 
			 }catch(Exception e) { 
				 System.out.println("Unknowned Exception !!!!"); 
				 e.printStackTrace(); 
			 } 
	 }
	public static Map getProductById(Object productId){
		 ProductUtil.cloudSolrServer.setDefaultCollection("product");
		 SolrQuery query = new SolrQuery();
		 query.setQuery("productId:"+productId);
		 QueryResponse response;
		 Map<String, Object> productMap=new HashMap<String,Object>();
		try {
			response = ProductUtil.cloudSolrServer.query(query);
			SolrDocumentList documentList=response.getResults();
			for (SolrDocument solrDocument : documentList) {
				productMap=solrDocument.getFieldValueMap();
			}
		} catch (SolrServerException e) {
				e.printStackTrace();
		}  
		 return productMap;
	 }
	
	 public static List<Map<String,Object>> getProductByCompany(Integer companyId) {
		 ProductUtil.cloudSolrServer.setDefaultCollection("product");
		 SolrQuery query = new SolrQuery();
		 query.setQuery(" companyId:"+companyId);
		 query.setRows(10000000);
		 QueryResponse response;
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try {
			response = ProductUtil.cloudSolrServer.query(query);
			SolrDocumentList documentList=response.getResults();
			for (SolrDocument solrDocument : documentList) {
				list.add(solrDocument.getFieldValueMap());
			}
		} catch (SolrServerException e) {
				e.printStackTrace();
		}  
		 return list;
		
}
}
