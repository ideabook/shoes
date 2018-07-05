package com.xxzx.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class Fundtype {
	@Expose
	private Integer fid;
	@Expose
	private String ftype;
	private String fno;
	private Double fcount;
	private Date fstart;
	private Date fend;
	private Double fleft;
	private Double fused;

	private Set<Contractinfo> contractinfos = new HashSet<Contractinfo>();

	public Double getFused() {
		return fused;
	}

	public Set<Contractinfo> getContractinfos() {
		return contractinfos;
	}

	public void setContractinfos(Set<Contractinfo> contractinfos) {
		this.contractinfos = contractinfos;
	}

	public void setFused(Double fused) {
		this.fused = fused;
	}

	public String getFno() {
		return fno;
	}

	public void setFno(String fno) {
		this.fno = fno;
	}

	private String fmore;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFtype() {
		return ftype;
	}

	public void setFtype(String ftype) {
		this.ftype = ftype;
	}

	public String getFmore() {
		return fmore;
	}

	public void setFmore(String fmore) {
		this.fmore = fmore;
	}

	public Double getFcount() {
		return fcount;
	}

	public void setFcount(Double fcount) {
		this.fcount = fcount;
	}

	public Date getFstart() {
		return fstart;
	}

	public Double getFleft() {
		return fleft;
	}

	public void setFleft(Double fleft) {
		this.fleft = fleft;
	}

	public void setFstart(Date fstart) {
		this.fstart = fstart;
	}

	public Date getFend() {
		return fend;
	}

	public void setFend(Date fend) {
		this.fend = fend;
	}

}
