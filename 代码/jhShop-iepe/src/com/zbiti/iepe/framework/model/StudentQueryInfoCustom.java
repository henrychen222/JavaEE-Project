/**
 * 
 */
package com.zbiti.iepe.framework.model;


/**
 *<p>按条件查询学生学籍的扩展类</p>
 * @author:y.you
 * 2016年3月31日
 * @version：v1.0
 */
public class StudentQueryInfoCustom extends QueryInfo{
	private String studentId;
	private String studentName;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
}
