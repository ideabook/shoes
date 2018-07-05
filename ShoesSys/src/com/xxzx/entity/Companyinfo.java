package com.xxzx.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class Companyinfo {
	@Expose
	private Integer comid;
	@Expose
	private String comname;
	@Expose
	private String comaddress;
	private String combank;
	private String comcontacts;
	private String commore;
	private String comtel;
	private Date comregtime;
	
	
	//外键
	private Set<Contractinfo> contractinfos= new HashSet<Contractinfo>();
	
	public Set<Contractinfo> getContractinfos() {
		return contractinfos;
	}
	public void setContractinfos(Set<Contractinfo> contractinfos) {
		this.contractinfos = contractinfos;
	}
	public Date getComregtime() {
		return comregtime;
	}
	public void setComregtime(Date comregtime) {
		this.comregtime = comregtime;
	}
	public String getComtel() {
		return comtel;
	}
	public void setComtel(String comtel) {
		this.comtel = comtel;
	}
	private Set<Contractinfo> companyinfos = new HashSet<Contractinfo>();
	public Integer getComid() {
		return comid;
	}
	public void setComid(Integer comid) {
		this.comid = comid;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public String getComaddress() {
		return comaddress;
	}
	public void setComaddress(String comaddress) {
		this.comaddress = comaddress;
	}
	public String getCombank() {
		return combank;
	}
	public void setCombank(String combank) {
		this.combank = combank;
	}
	public String getComcontacts() {
		return comcontacts;
	}
	public void setComcontacts(String comcontacts) {
		this.comcontacts = comcontacts;
	}
	public String getCommore() {
		return commore;
	}
	public void setCommore(String commore) {
		this.commore = commore;
	}
	public Set<Contractinfo> getCompanyinfos() {
		return companyinfos;
	}
	public void setCompanyinfos(Set<Contractinfo> companyinfos) {
		this.companyinfos = companyinfos;
	}

	
}
