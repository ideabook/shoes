package com.xxzx.entity;

import java.util.Date;

import com.google.gson.annotations.Expose;

public class Paymode {

	@Expose
	private Integer pmid;		// pmid 流水编号
	@Expose
	private Integer cid;		// cid 合同编号
	private Integer pmstep;		// pmstep 付款步骤
	private String pmtype;		// Pmtype 付款项目
	private Double pmpercent;	// pmpercent 付款比例
	private Double pmcount;		// pmcount 付款金额
	private Date pmdate;		// pmdate 应付款日期
	private Integer pmstate;		//是否付款
	private String pmmore;		//备注
	
	//外键
	private Contractinfo contractinfo;
	
	public Integer getPmid() {
		return pmid;
	}
	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public Integer getPmstep() {
		return pmstep;
	}
	public void setPmstep(Integer pmstep) {
		this.pmstep = pmstep;
	}
	public String getPmtype() {
		return pmtype;
	}
	public void setPmtype(String pmtype) {
		this.pmtype = pmtype;
	}
	public Double getPmpercent() {
		return pmpercent;
	}
	public void setPmpercent(Double pmpercent) {
		this.pmpercent = pmpercent;
	}
	public Double getPmcount() {
		return pmcount;
	}
	public void setPmcount(Double pmcount) {
		this.pmcount = pmcount;
	}
	public Date getPmdate() {
		return pmdate;
	}
	public void setPmdate(Date pmdate) {
		this.pmdate = pmdate;
	}
	public String getPmmore() {
		return pmmore;
	}
	public void setPmmore(String pmmore) {
		this.pmmore = pmmore;
	}
	public Integer getPmstate() {
		return pmstate;
	}
	public void setPmstate(Integer pmstate) {
		this.pmstate = pmstate;
	}
	public Contractinfo getContractinfo() {
		return contractinfo;
	}
	public void setContractinfo(Contractinfo contractinfo) {
		this.contractinfo = contractinfo;
	}
	@Override
	public String toString() {
		return "Paymode [pmid=" + pmid + ", cid=" + cid + ", pmstep=" + pmstep
				+ ", pmtype=" + pmtype + ", pmpercent=" + pmpercent
				+ ", pmcount=" + pmcount + ", pmdate=" + pmdate + ", pmstate="
				+ pmstate + ", pmmore=" + pmmore + ", contractinfo="
				+ contractinfo + "]";
	}
	
	
}
