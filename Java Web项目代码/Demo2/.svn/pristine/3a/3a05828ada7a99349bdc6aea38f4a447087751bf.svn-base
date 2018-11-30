package com.jd.export.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;

@SuppressWarnings("all")
public class ExportExcel{

	/**
	 * 导出
	 * @param list 数据
	 * @param columnMap 第一行中文信息
	 * @param xlsName excel文件名
	 * @param sheetName 工作薄
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void exportExcel(List list,String [] columnNames,String []keys,String xlsName,String sheetName,HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
        workbook.setSheetName(0, sheetName);
        HSSFRow row = sheet.createRow((short) 0);
        HSSFCell cell;
        // 创建单元格样式  
        HSSFCellStyle cellStyleTitle = workbook.createCellStyle();  
        // 指定单元格居中对齐  
        cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        // 指定单元格垂直居中对齐  
        cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
        // 指定当单元格内容显示不下时自动换行  
        cellStyleTitle.setWrapText(true);  
        // ------------------------------------------------------------------  
        HSSFCellStyle cellStyle = workbook.createCellStyle();  
        // 指定单元格居中对齐  
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
        // 指定单元格垂直居中对齐  
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
        // 指定当单元格内容显示不下时自动换行  
        cellStyle.setWrapText(true);  
        // ------------------------------------------------------------------  
        // 设置单元格字体 第一行
        HSSFFont f = workbook.createFont();  
        f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        f.setFontName("宋体");  
        f.setFontHeight((short) 250); 
        cellStyleTitle.setFont(f);
        cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
        // 设置单元格字体 内容
        HSSFFont f1 = workbook.createFont();  
        f1.setFontName("宋体");  
        f1.setFontHeight((short) 200); 
        cellStyle.setFont(f1); 
        cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
        cellStyle.setBorderRight(CellStyle.BORDER_THIN);
        cellStyle.setBorderTop(CellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
        
        // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
        for(int i=0;i<columnNames.length;i++){
            sheet.setColumnWidth((short) i, (short) (45 * 150));
        }
        // 写入各个字段的名称
        for (int i = 0; i < columnNames.length; i++) {
            cell = row.createCell((short) (i));
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            cell.setCellValue(columnNames[i]);
            cell.setCellStyle(cellStyleTitle);
        }
        
        //设置每行每列的值
        for (short i = 1; i <= list.size(); i++) {
        	Map listMap = (Map)list.get(i-1);
            // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
            // 创建一行，在页sheet上
            Row row1 = sheet.createRow((short) i);
            // 在row行上创建一个方格
            for(short j=0;j<keys.length;j++){
                Cell cell1 = row1.createCell(j);
                cell1.setCellValue(listMap.get(keys[j]) == null?" ": listMap.get(keys[j]).toString());
                cell1.setCellStyle(cellStyle);
            }
        }
        
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File file1 = new File(realPath+"/xml");
        if(!file1.exists()){ //判断此文件夹是否存在 不存在 创建
        	file1.mkdir();
        }
        FileOutputStream fOut = new FileOutputStream(realPath + "/xml/" + xlsName);
        workbook.write(fOut);
        fOut.flush();
        fOut.close();
        
     // 先建立一个文件读取流去读取这个临时excel文件
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(realPath + "xml/" + xlsName);
        } catch (FileNotFoundException e) {
            return;
        }
        response.setContentType("APPLICATION/OCTET-STREAM");
        String excelName = null;
        try {
            excelName = URLEncoder.encode(xlsName, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
        }
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + excelName + "\"");
        // 写出流信息
        int b = 0;
        try {
            PrintWriter out = response.getWriter();
            while ((b = fs.read()) != -1) {
                out.write(b);
            }
            fs.close();
            out.close();
        } catch (Exception e) {
        }
        File file = new File(realPath + "/xml/" + xlsName);
        if (file.isFile() & file.exists())
            file.delete();
	}
	
	
	/**
	 * 批量导出
	 * @param totallist
	 * @param columnNameList
	 * @param keyList
	 * @param xlsNameList
	 * @param sheetName
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	public static void exportplExcel(List totallist,List columnNameList,List keyList,List sheetName,List xlsNameList,HttpServletRequest request,HttpServletResponse response) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		String xlsName =(String)xlsNameList.get(0);
		String realPath = request.getSession().getServletContext().getRealPath("/");
	    if(totallist!=null&&totallist.size()>0){
		for (int k=0;k<totallist.size();k++) {
	
			List list =(List)totallist.get(k);
			String [] columnNames = (String[]) columnNameList.get(k);	
			String [] keys = (String[]) keyList.get(k);	
		
			HSSFSheet sheet=null;
			HSSFRow row=null;
			sheet = workbook.createSheet();
		    workbook.setSheetName(k, (String)sheetName.get(k));
		    row = sheet.createRow((short) 0);
		    HSSFCell cell;
		    // 创建单元格样式  
		    HSSFCellStyle cellStyleTitle = workbook.createCellStyle();  
		    // 指定单元格居中对齐  
		    cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
		    // 指定单元格垂直居中对齐  
		    cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
		    // 指定当单元格内容显示不下时自动换行  
		    cellStyleTitle.setWrapText(true);  
		    // ------------------------------------------------------------------  
		    HSSFCellStyle cellStyle = workbook.createCellStyle();  
		    // 指定单元格居中对齐  
		    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
		    // 指定单元格垂直居中对齐  
		    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
		    // 指定当单元格内容显示不下时自动换行  
		    cellStyle.setWrapText(true);  
		    // ------------------------------------------------------------------  
		    // 设置单元格字体 第一行
		    HSSFFont f = workbook.createFont();  
		    f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
		    f.setFontName("宋体");  
		    f.setFontHeight((short) 250); 
		    cellStyleTitle.setFont(f);
		    cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);
		    cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);
		    cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);
		    cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN);
		    cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
		    // 设置单元格字体 内容
		    HSSFFont f1 = workbook.createFont();  
		    f1.setFontName("宋体");  
		    f1.setFontHeight((short) 200); 
		    cellStyle.setFont(f1); 
		    cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
		    cellStyle.setBorderRight(CellStyle.BORDER_THIN);
		    cellStyle.setBorderTop(CellStyle.BORDER_THIN);
		    cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
		    cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
		    
		    // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
		    for(int i=0;i<columnNames.length;i++){
		        sheet.setColumnWidth((short) i, (short) (45 * 150));
		    }
		    // 写入各个字段的名称
		    for (int i = 0; i < columnNames.length; i++) {
		        cell = row.createCell((short) (i));
		        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		        cell.setCellValue(columnNames[i]);
		        cell.setCellStyle(cellStyleTitle);
		    }
		    
		    
		    //设置每行每列的值
		    for (short i = 1; i <= list.size(); i++) {
		    	Map listMap = (Map)list.get(i-1);
		        // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
		        // 创建一行，在页sheet上
		        Row row1 = sheet.createRow((short) i);
		        // 在row行上创建一个方格
		        for(short j=0;j<keys.length;j++){
		            Cell cell1 = row1.createCell(j);
		            cell1.setCellValue(listMap.get(keys[j]) == null?" ": listMap.get(keys[j]).toString());
		            cell1.setCellStyle(cellStyle);
		        }
		    }
		    
		    File file1 = new File(realPath+"/xml");
		    if(!file1.exists()){ //判断此文件夹是否存在 不存在 创建
		    	file1.mkdir();
		    }
		    FileOutputStream fOut = new FileOutputStream(realPath + "/xml/" + xlsName);
		    workbook.write(fOut);
		    fOut.flush();
		    fOut.close();
		}
		}else{
			for (int k=0;k<columnNameList.size();k++){
				
				List list =new ArrayList();
				String [] columnNames = (String[]) columnNameList.get(k);	
				String [] keys = (String[]) keyList.get(k);	
			
				HSSFSheet sheet=null;
				HSSFRow row=null;
				sheet = workbook.createSheet();
			    workbook.setSheetName(k, (String)sheetName.get(k));
			    row = sheet.createRow((short) 0);
			    HSSFCell cell;
			    // 创建单元格样式  
			    HSSFCellStyle cellStyleTitle = workbook.createCellStyle();  
			    // 指定单元格居中对齐  
			    cellStyleTitle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
			    // 指定单元格垂直居中对齐  
			    cellStyleTitle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
			    // 指定当单元格内容显示不下时自动换行  
			    cellStyleTitle.setWrapText(true);  
			    // ------------------------------------------------------------------  
			    HSSFCellStyle cellStyle = workbook.createCellStyle();  
			    // 指定单元格居中对齐  
			    cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);  
			    // 指定单元格垂直居中对齐  
			    cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);  
			    // 指定当单元格内容显示不下时自动换行  
			    cellStyle.setWrapText(true);  
			    // ------------------------------------------------------------------  
			    // 设置单元格字体 第一行
			    HSSFFont f = workbook.createFont();  
			    f.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
			    f.setFontName("宋体");  
			    f.setFontHeight((short) 250); 
			    cellStyleTitle.setFont(f);
			    cellStyleTitle.setBorderLeft(CellStyle.BORDER_THIN);
			    cellStyleTitle.setBorderRight(CellStyle.BORDER_THIN);
			    cellStyleTitle.setBorderTop(CellStyle.BORDER_THIN);
			    cellStyleTitle.setBorderBottom(CellStyle.BORDER_THIN);
			    cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
			    // 设置单元格字体 内容
			    HSSFFont f1 = workbook.createFont();  
			    f1.setFontName("宋体");  
			    f1.setFontHeight((short) 200); 
			    cellStyle.setFont(f1); 
			    cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
			    cellStyle.setBorderRight(CellStyle.BORDER_THIN);
			    cellStyle.setBorderTop(CellStyle.BORDER_THIN);
			    cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
			    cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
			    
			    // 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。
			    for(int i=0;i<columnNames.length;i++){
			        sheet.setColumnWidth((short) i, (short) (45 * 150));
			    }
			    // 写入各个字段的名称
			    for (int i = 0; i < columnNames.length; i++) {
			        cell = row.createCell((short) (i));
			        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			        cell.setCellValue(columnNames[i]);
			        cell.setCellStyle(cellStyleTitle);
			    }
			    
			    if(list!=null&&list.size()!=0){
			    //设置每行每列的值
			    for (short i = 1; i <= list.size(); i++) {
			    	Map listMap = (Map)list.get(i-1);
			        // Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的
			        // 创建一行，在页sheet上
			        Row row1 = sheet.createRow((short) i);
			        // 在row行上创建一个方格
			        for(short j=0;j<keys.length;j++){
			            Cell cell1 = row1.createCell(j);
			            cell1.setCellValue(listMap.get(keys[j]) == null?" ": listMap.get(keys[j]).toString());
			            cell1.setCellStyle(cellStyle);
			        }
			    }
			    }
			    
			    File file1 = new File(realPath+"/xml");
			    if(!file1.exists()){ //判断此文件夹是否存在 不存在 创建
			    	file1.mkdir();
			    }
			    FileOutputStream fOut = new FileOutputStream(realPath + "/xml/" + xlsName);
			    workbook.write(fOut);
			    fOut.flush();
			    fOut.close();
				
				
			}
			
			
		}
		
		
		// 先建立一个文件读取流去读取这个临时excel文件
	    FileInputStream fs = null;
	    try {
	        fs = new FileInputStream(realPath + "xml/" + xlsName);
	    } catch (FileNotFoundException e) {
	        return;
	    }
	    response.setContentType("APPLICATION/OCTET-STREAM");
	    String excelName = null;
	    try {
	        excelName = URLEncoder.encode(xlsName, "UTF-8");
	    } catch (UnsupportedEncodingException e1) {
	    }
	    response.setHeader("Content-Disposition", "attachment; filename=\""
	            + excelName + "\"");
	    // 写出流信息
	    int b = 0;
	    try {
	        PrintWriter out = response.getWriter();
	        while ((b = fs.read()) != -1) {
	            out.write(b);
	        }
	        fs.close();
	        out.close();
	    } catch (Exception e) {
	    }
	    File file = new File(realPath + "/xml/" + xlsName);
	    if (file.isFile() & file.exists())
	        file.delete();
	}
	
}