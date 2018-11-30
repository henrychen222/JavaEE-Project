package com.zbiti.iepe.framework.controller;

import java.io.RandomAccessFile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * 类名称: LogController 类描述: 创建人: 徐泰丰 创建时间: 2014-4-17 上午10:29:51 修改人: 修改时间: 修改备注:
 * 版本: v1.0
 * 
 */

@Controller
@RequestMapping("/log")
public class LogController {
	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	public ModelAndView out(
			@RequestParam(value = "path", required = false, defaultValue = "/work/apache-tomcat-6.0.37/logs/EomsOut.log") String path,
			@RequestParam(value = "line", required = false, defaultValue = "100") int line,
			@RequestParam(value = "charset", required = false, defaultValue = "UTF-8") String charset) {
		ModelAndView mv = new ModelAndView("log/msg");
		String msg = "";
		try {
			msg = getLog(path, line, charset);
			mv.addObject("msg", msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	private String getLog(String filename, int max, String charset) {
		StringBuilder out = new StringBuilder();
		RandomAccessFile rf = null;
		try {
			rf = new RandomAccessFile(filename, "r");
			long len = rf.length();
			long start = rf.getFilePointer();
			long nextend = start + len - 1;
			String line;
			rf.seek(nextend);
			int c = -1;
			int count = 0;
			while (nextend > start) {
				c = rf.read();
				if (c == '\n' || c == '\r') {
					if (count == max) {
						break;
					}
					count++;
					line = rf.readLine();
					if (line != null) {
						out.append(
								new String(line.getBytes("ISO-8859-1"), charset))
								.append("<br>");
					}
					nextend--;
				}
				nextend--;
				rf.seek(nextend);
				if (nextend == 0) {
					out.append(
							new String(rf.readLine().getBytes("ISO-8859-1"),
									charset)).append("<br>");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rf != null)
					rf.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return out.toString();
	}

}
