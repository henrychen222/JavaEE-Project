package com.yz.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;

import com.yz.domain.Product;

public class ImageUploadUtil {
	
	//图片上传并获取表单的其他信息
	@SuppressWarnings({ "unchecked" })
	public static Product doUploadImage(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		response.setContentType("text/html;charset=utf-8");
		Product pt = new Product();
		PrintWriter out = response.getWriter();  
		  // 设置上传文件最大为 5M
		  final long MAX_SIZE = 5 * 1024 * 1024;  
		  // 允许上传图片的文件格式的列表  
		  final String[] allowedExt = new String[] { "jpg", "jpeg", "gif", "png" };  
		  // 实例化一个硬盘文件工厂,用来配置上传组件UploadServlet  
		  DiskFileItemFactory dfif = new DiskFileItemFactory();  
		  dfif.setSizeThreshold(4096);// 临时存放文件的内存大小,这里是4K.多于的部分将临时存在硬盘  
		  File savedir =new File(request.getSession().getServletContext().getRealPath("\\") + "images\\" + "imagesUploadTemp");
		  if(!savedir.exists()) savedir.mkdirs();//如果目录不存在就创建
		  dfif.setRepository(savedir);// 设置存放临时文件的目录,web根目录下的ImagesUploadTemp目录  
		  // 用以上工厂实例化上传组件  
		  ServletFileUpload sfu = new ServletFileUpload(dfif);  
		  // 设置最大上传尺寸  
		  sfu.setSizeMax(MAX_SIZE);
		  // 从request得到 所有 上传域的列表  
		  List fileList = null;  
		  try {  
		   fileList = sfu.parseRequest(request);  
		  } catch (FileUploadException e) {
		   // 处理文件尺寸过大异常  
		   if (e instanceof SizeLimitExceededException) {  
		    out.println("图片超过规定大小:" + MAX_SIZE + "字节<p />");  
		    return null;  
		   }  
		   e.printStackTrace();  
		  }  
		  // 没有文件上传  
		  if (fileList == null || fileList.size() == 0) {  
		   out.println("请选择上传文件<p />");  
		   return null;  
		  }  
		  Iterator fileItr = fileList.iterator();// 得到所有上传的文件    
		  // 循环处理所有文件  
		  while (fileItr.hasNext()) {  
			  FileItem fileItem = null;  
			   fileItem = (FileItem) fileItr.next();// 得到当前文件 
			   // 打印form字段而不是上传域的文件域(<input type="text" />等) 
			   if (fileItem.isFormField()) { 
				   String name = fileItem.getFieldName(); //得到元素名
				   InputStream stream = fileItem.getInputStream();
				   		if(name.equals("title")){
				   			pt.setName(Streams.asString(stream, "utf-8"));
				   		}else if(name.equals("category")){
				   			pt.setCategory(Streams.asString(stream, "utf-8"));
				   			
				   		}else if(name.equals("trading")){
				   			pt.setTrading(Streams.asString(stream,"utf-8"));
				   						
				   		}				   				   					   		
				   		else if(name.equals("originalprice")){
				   			float price = Float.parseFloat(Streams.asString(stream, "utf-8"));
				   			pt.setOriginalprice(price);
				   			
				   		}else if(name.equals("price")){
				   			float price = Float.parseFloat(Streams.asString(stream, "utf-8"));
				   			pt.setPrice(price);
				   			
				   		}else if(name.equals("description")){
				   			pt.setDescription(Streams.asString(stream, "utf-8"));
				   			
				   		}else if(name.equals("trading")){
				   			pt.setTrading(Streams.asString(stream, "utf-8"));
				   		}
			   		}else { 
					   String path = null;  
					   long size = 0;  
					   path = fileItem.getName();// 得到文件的完整路径   
					   size = fileItem.getSize();// 得到文件的大小    
					   if ("".equals(path) || size == 0) {  
					    out.println("请选择上传文件<p />"); 
					    return null;  
					   }  
					   String i_name = path.substring(path.lastIndexOf("\\") + 1); // 得到去除路径的文件名  
					   String suffix = i_name.substring(i_name.lastIndexOf(".") + 1);//得到文件的扩展名(无扩展名时将得到全名)   
					   // 拒绝接受规定文件格式之外的文件类型  
					   int allowFlag = 0;  
					   int allowedExtCount = allowedExt.length;  
					   for (; allowFlag < allowedExtCount; allowFlag++) {  
					    if (allowedExt[allowFlag].equals(suffix))  
					     break;  
					   }  
					   if (allowFlag == allowedExtCount) {  
					    out.println("请上传以下类型的文件<p />");  
					    for (allowFlag = 0; allowFlag < allowedExtCount; allowFlag++)  
					     out.println("*." + allowedExt[allowFlag]  
					       + "&nbsp;&nbsp;&nbsp;");  
					    return null;  
					   }
					   //用UUID工具类生成上传图片的名称
					   String image = UUIDUtils.generateID();  
					   // 保存的最终文件完整路径,保存在web根目录下的ImagesUploaded目录下
					   String artwork = "images/productimages";
					   String imagesPath = request.getSession().getServletContext().getRealPath(artwork)+"\\"+ image + "." + suffix;
					   try {  
					    // 保存原文件  
					    fileItem.write(new File(imagesPath));
					    //生成200x200略缩图
					    String pathdir200 = "/images/image200x";//200宽度的图片保存目录
						String realpathdir200 = request.getSession().getServletContext().getRealPath(pathdir200);
						File savedir200 = new File(realpathdir200);
						if(!savedir200.exists()) savedir200.mkdirs();//如果目录不存在就创建
					    ImageSizerUtil imageAbbreviate = new ImageSizerUtil();
					    	imageAbbreviate.compressPic(request.getSession().getServletContext().getRealPath(artwork)+"\\", realpathdir200 +"\\", image+"."+suffix, image+"."+suffix, 200, 200, false);
					    pt.setUploadImage(image + "." + suffix);
					    return pt;
					    //out.println("文件上传成功. 已保存为: " + image + "." + suffix + " &nbsp;&nbsp;文件大小: " + size + "字节<p />");  
					   } catch (Exception e) {
					    e.printStackTrace();  
					   }finally //总是立即删除保存表单字段内容的临时文件 
		                { 
						   fileItem.delete(); 
		                }
			  }
	    }
		return null;
	}
}
