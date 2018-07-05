package com.xxzx.entity;

import java.util.HashSet;
import java.util.Set;

public class Department {
	/**
	 * 部门
	 */
	private Integer did;
	private String dname;
	private Set<Userinfo> userinfos=new HashSet<Userinfo>();
	public Set<Userinfo> getUserinfos() {
		return userinfos;
	}
	public void setUserinfos(Set<Userinfo> userinfos) {
		this.userinfos = userinfos;
	}
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDmore() {
		return dmore;
	}
	public void setDmore(String dmore) {
		this.dmore = dmore;
	}
	private String dmore;
}
