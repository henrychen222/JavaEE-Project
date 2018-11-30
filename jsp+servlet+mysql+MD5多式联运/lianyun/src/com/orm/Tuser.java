package com.orm;

public class Tuser
{
	public String id;
	public String loginname;
	private String loginpw;
	private String name;
	private String sex;
	private int age;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLoginname()
	{
		return loginname;
	}
	
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public void setLoginname(String loginname)
	{
		this.loginname = loginname;
	}
	public String getLoginpw()
	{
		return loginpw;
	}
	public void setLoginpw(String loginpw)
	{
		this.loginpw = loginpw;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getSex()
	{
		return sex;
	}
	public void setSex(String sex)
	{
		this.sex = sex;
	}

}
