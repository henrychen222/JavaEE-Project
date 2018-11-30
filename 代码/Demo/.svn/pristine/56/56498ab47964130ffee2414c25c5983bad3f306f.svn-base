package com.jd.export.util;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelExporter {
	private static final Logger log = LoggerFactory
			.getLogger(ExcelExporter.class);

	private ExcelExporter() {
	}

	// ordertime=订单时间,paytime=支付时间
	public static String export(List<Map<String, Object>> rows, String columns) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			List<String> headers = new ArrayList<String>();
			List<String> headersTitle = new ArrayList<String>();
			for (String str : columns.split(",")) {// 以逗号位分界线
				String[] arr = str.split("\\=");// 取出来ordertime=订单时间，再以=为分界线
				headers.add(arr[0]);// 取ordertime
				headersTitle.add(arr[1]);// 取订单时间
			}
			XSSFWorkbook wb = new XSSFWorkbook();
			XSSFFont f = wb.createFont();
			f.setFontName("宋体");
			f.setFontHeightInPoints((short) 10);
			XSSFFont fh = wb.createFont();
			fh.setFontName("宋体");
			fh.setFontHeightInPoints((short) 10);
			fh.setBold(true);
			XSSFCellStyle s = wb.createCellStyle();
			s.setFont(f);
			s.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			XSSFCellStyle sh = wb.createCellStyle();
			sh.setFont(fh);
			sh.setAlignment(XSSFCellStyle.ALIGN_CENTER);
			XSSFSheet sheet = wb.createSheet();
			XSSFRow rh = sheet.createRow(0);
			for (int i = 0; i < headersTitle.size(); ++i) {
				XSSFCell c = rh.createCell(i);
				c.setCellValue(headersTitle.get(i));
				c.setCellStyle(sh);
			}
			for (int i = 0; i < rows.size(); ++i) {
				Map<String, Object> row = rows.get(i);
				XSSFRow r = sheet.createRow(i + 1);
				for (int j = 0; j < headersTitle.size(); ++j) {
					Object val = row.get(headers.get(j));
					XSSFCell c = r.createCell(j);
					if (val == null) {
						c.setCellValue("");
					} else if (val instanceof Integer) {
						c.setCellValue((Integer) val);
					} else if (val instanceof Long) {
						c.setCellValue((Long) val);
					} else if (val instanceof Timestamp) {
						c.setCellValue(sdf.format((Timestamp) val));
					} else if (val instanceof String) {
						c.setCellValue((String) val);
					} else if (val instanceof BigDecimal) {
						c.setCellValue(((BigDecimal) val).doubleValue());
					} else {
						c.setCellValue(val.toString());
					}
					c.setCellStyle(s);
				}
			}
			for (int i = 0; i < headersTitle.size(); ++i) {
				sheet.autoSizeColumn((short) i);// 调整列宽
			}
			/*
			 * String fileName = date + "_" + title + (subTitle.length() != 0 ?
			 * ("_" + subTitle) : "") + ".xlsx";
			 */
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			wb.write(baos);// 将工作簿以字节流的形式输出
			wb.close();
			String result1 = FileUploader.upload(baos.toByteArray(), "xlsx");// 防止浏览器不识别，将字节流转化为字节数组
			baos.close();
			return result1;
		} catch (Exception e) {
			log.error("导出Excel失败！", e);
			return "";
		}
	}
}
