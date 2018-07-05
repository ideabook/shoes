package com.xxzx.entity;

import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class Confrom {
	@Expose
	private Integer cfid;
	@Expose
	private String cffrom;
	private String cfmore;
	private Set<Contractinfo> contractinfos=new HashSet<Contractinfo>();
	
	public Set<Contractinfo> getContractinfos() {
		return contractinfos;
	}
	public void setContractinfos(Set<Contractinfo> contractinfos) {
		this.contractinfos = contractinfos;
	}
	public Integer getCfid() {
		return cfid;
	}
	public void setCfid(Integer cfid) {
		this.cfid = cfid;
	}
	
	public String getCffrom() {
		return cffrom;
	}
	public void setCffrom(String cffrom) {
		this.cffrom = cffrom;
	}
	public String getCfmore() {
		return cfmore;
	}
	public void setCfmore(String cfmore) {
		this.cfmore = cfmore;
	}

	
	
}
