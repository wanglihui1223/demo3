package com.newer.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name="s_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uid;	
	private String name;
	private String upwd;
	private String sex;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String photo; 

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return name;
	}

	public void setUname(String uname) {
		this.name = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public String getBirthdayString() {
		if(this.birthday!=null) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			return sdf.format(this.birthday);
		}
		return null;
	}
	

}
