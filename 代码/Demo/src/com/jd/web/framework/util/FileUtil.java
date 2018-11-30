package com.jd.web.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 用于复制文件
 * 
 * @author ChengKai
 * 
 */
public class FileUtil {
	/**
	 * 复制文件
	 * 
	 * @param oldPath
	 * @param newPath
	 */
	public static void copyFile(String oldPath, String newPath) {
		try {
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
				fs.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}
	}
	
	/**
	 * Url处理
	 * 
	 * @Function: com.zbiti.iepe.framework.util.FileUtil.handleURL
	 * @Description:
	 *
	 * @return
	 *
	 * @date:2015年8月27日 上午9:32:16
	 *
	 * @Modification History:
	 * @date:2015年8月27日     @author:Administrator     create
	 */
	public static String handleURL(String url){
		String newURL = "";
		if(url != null && url.trim().length() >0){
			newURL = url.replaceAll("121.40.206.22", "images.51juhe.com");
			return newURL;
		}else{
			return url;
		}
		
	}

	public static void mkdir() {

	}
	public static void main(String[] args) {
		String str = "http://121.40.206.22/picture/20150826/nocompanyname/ed55ce343913b5e8e961e68a245fa72e.jpg";
		String newStr = FileUtil.handleURL(str);
		System.out.println(newStr);
	}
}
