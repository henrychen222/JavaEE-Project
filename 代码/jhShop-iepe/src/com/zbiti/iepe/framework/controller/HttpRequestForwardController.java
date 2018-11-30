package com.zbiti.iepe.framework.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zbiti.core.controller.BaseController;
import com.zbiti.iepe.framework.model.BaseUser;

@Controller
@RequestMapping("/reqfwd")
public class HttpRequestForwardController extends BaseController {
	static {
		Resource resource = new ClassPathResource("iepe.properties");
		try {
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			FORWARD_URL = props.get("FORWARD_URL").toString();
			FORWARD_URL_DOC = props.get("FORWARD_URL_DOC").toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static String FORWARD_URL;
	private static String FORWARD_URL_DOC;

	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping("reqfwd")
	public void reqfwd(HttpServletRequest request,
			HttpServletResponse response, HttpSession session,String paramaterSize)
			throws IOException {
		if(paramaterSize==null||paramaterSize==""){
			paramaterSize="&op=zoom&resolutions=200x150,200x200!";
		}else{
			paramaterSize=paramaterSize.replace("*", "&");
		}
		BaseUser user = (BaseUser) session.getAttribute("user");
		URL url = null;
		if ("".equals(user) || user == null) {
			url = new URL(FORWARD_URL + "?vendor=jhshop"+paramaterSize);
		} else {
			url = new URL(FORWARD_URL + "?vendor=jhshop"+paramaterSize);
		}

		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		huc.setDoInput(true);
		huc.setDoOutput(true);
		Enumeration<String> en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			String val = request.getHeader(key);
			huc.setRequestProperty(key, val);
		}
		// forward data.
		InputStream is = request.getInputStream();
		OutputStream os = huc.getOutputStream();
		byte[] buf = new byte[10240];
		int len;
		while ((len = is.read(buf)) > 0) {
			os.write(buf, 0, len);
		}
		is.close();
		os.close();
		// read and return response data.
		InputStream iss = huc.getInputStream();
		OutputStream oss = response.getOutputStream();
		while ((len = iss.read(buf)) > 0) {
			oss.write(buf, 0, len);
		}
		iss.close();
		oss.close();
	}
	
	@ResponseBody
	@RequestMapping("reqfwddoc")
	public void reqfwddoc(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws IOException {
		BaseUser user = (BaseUser) session.getAttribute("user");
		
		URL url = null;
		if ("".equals(user) || user == null) {
			url = new URL(FORWARD_URL_DOC);
		} else {
			url = new URL(FORWARD_URL_DOC + "?vendor=jhshop");
		}
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		huc.setDoInput(true);
		huc.setDoOutput(true);
		Enumeration<String> en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			String val = request.getHeader(key);
			huc.setRequestProperty(key, val);
		}
		// forward data.
		InputStream is = request.getInputStream();
		OutputStream os = huc.getOutputStream();
		byte[] buf = new byte[10240];
		int len;
		while ((len = is.read(buf)) > 0) {
			os.write(buf, 0, len);
		}
		is.close();
		os.close();
		// read and return response data.
		InputStream iss = huc.getInputStream();
		OutputStream oss = response.getOutputStream();
		while ((len = iss.read(buf)) > 0) {
			oss.write(buf, 0, len);
		}
		iss.close();
		oss.close();
	}
	
	@ResponseBody
	@RequestMapping("forKindEditor")
	public Map<String, Object> forKindEditor(HttpServletRequest request)
			throws IOException {
		URL url = new URL(FORWARD_URL);
		HttpURLConnection huc = (HttpURLConnection) url.openConnection();
		huc.setDoInput(true);
		huc.setDoOutput(true);
		Enumeration en = request.getHeaderNames();
		while (en.hasMoreElements()) {
			String key = en.nextElement().toString();
			String val = request.getHeader(key);
			huc.setRequestProperty(key, val);
		}
		// forward data.
		InputStream is = request.getInputStream();
		OutputStream os = huc.getOutputStream();
		byte[] buf = new byte[10240];
		int len;
		while ((len = is.read(buf)) > 0) {
			os.write(buf, 0, len);
		}
		is.close();
		os.close();
		// read and return response data.
		InputStream iss = huc.getInputStream();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while ((len = iss.read(buf)) > 0) {
			baos.write(buf, 0, len);
		}
		iss.close();
		// 转发的json格式不符合KindEditor要求，这里进行转义。取content第一个文件的url。
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json = JSONObject.fromObject(baos.toString("utf-8"));
		baos.close();
		try {
			map.put("error", 0);
			JSONObject content = (JSONObject) json.get("content");
			for (Object k : content.keySet()) {
				map.put("url", content.get(k));
				break;
			}
			return map;
		} catch (Exception e) {
			map.put("error", 1);
			map.put("message", e.getMessage() + " " + json.toString());
			return map;
		}
	}
}