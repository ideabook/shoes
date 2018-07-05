package com.xxzx.entity;

import java.util.HashSet;
import java.util.Set;


public class Userinfo {
	private Integer uid;
	private String uloginname ;
	private String upassword;
	private String ujobid;
	private String uname;
	private Integer udepartment;
	private String ulogintime;
	private Set<Role> roles = new HashSet<Role>();
	private Department department;
	
	public Set<Role> getRoles() {
		return roles;
	}
	private Set<Contractinfo> contractinfos=new HashSet<Contractinfo>();
	
	public Set<Contractinfo> getContractinfos() {
		return contractinfos;
	}
	public void setContractinfos(Set<Contractinfo> contractinfos) {
		this.contractinfos = contractinfos;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUloginname() {
		return uloginname;
	}
	public void setUloginname(String uloginname) {
		this.uloginname = uloginname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUjobid() {
		return ujobid;
	}
	public void setUjobid(String ujobid) {
		this.ujobid = ujobid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUlogintime() {
		return ulogintime;
	}
	public void setUlogintime(String ulogintime) {
		this.ulogintime = ulogintime;
	}
	public Integer getUdepartment() {
		return udepartment;
	}
	public void setUdepartment(Integer udepartment) {
		this.udepartment = udepartment;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
}
