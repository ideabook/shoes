package com.xxzx.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class Contype {
	@Expose
	private Integer ctid;
	@Expose
	private String cttype;
	private String ctmore;
	
	private Set<Contractinfo> contractinfos=new HashSet<Contractinfo>();
	public Set<Contractinfo> getContractinfos() {
		return contractinfos;
	}
	public void setContractinfos(Set<Contractinfo> contractinfos) {
		this.contractinfos = contractinfos;
	}
	public Integer getCtid() {
		return ctid;
	}
	public void setCtid(Integer ctid) {
		this.ctid = ctid;
	}
	public String getCttype() {
		return cttype;
	}
	public void setCttype(String cttype) {
		this.cttype = cttype;
	}
	public String getCtmore() {
		return ctmore;
	}
	public void setCtmore(String ctmore) {
		this.ctmore = ctmore;
	}

}
