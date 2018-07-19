/**
 * 
 */
package com.biz.model;

import java.util.Date;

/**
 * @author TangPeng
 *
 */
public class Student {

	private String id;
	private String name;
	private Date birthday;
	private String description;
	private int avgscore;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAvgscore() {
		return avgscore;
	}
	public void setAvgscore(int avgscore) {
		this.avgscore = avgscore;
	}
	public Student(String id, String name, Date birthday, String description, int avgscore) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.description = description;
		this.avgscore = avgscore;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", birthday=" + birthday + ", description=" + description
				+ ", avgscore=" + avgscore + "]";
	}
	
	
}
