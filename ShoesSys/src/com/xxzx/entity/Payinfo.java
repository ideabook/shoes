package com.xxzx.entity;

import java.util.Date;

public class Payinfo {
	private Integer pid;
	private Integer cid;
	private Integer fid;
	private Date pdate;
	private Double ptotal;
	private Double ppay;//付款金额
	private String pbankno;
	private Integer pfileid;
	private Date pregtime;
	private String poperator;
	//外键
	private Contractinfo contractinfo;
    private Fundtype fundtype;

    
    public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}
    
	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public Fundtype getFundtype() {
		return fundtype;
	}

	public void setFundtype(Fundtype fundtype) {
		this.fundtype = fundtype;
	}

	public Contractinfo getContractinfo() {
		return contractinfo;
	}
	
	public void setContractinfo(Contractinfo contractinfo) {
		this.contractinfo = contractinfo;
	}

	public Integer getPid() {
		return pid;
	}

	public Double getPpay() {
		return ppay;
	}

	public void setPpay(Double ppay) {
		this.ppay = ppay;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}


	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	public Double getPtotal() {
		return ptotal;
	}

	public void setPtotal(Double ptotal) {
		this.ptotal = ptotal;
	}

	public String getPbankno() {
		return pbankno;
	}

	public void setPbankno(String pbankno) {
		this.pbankno = pbankno;
	}

	public Integer getPfileid() {
		return pfileid;
	}

	public void setPfileid(Integer pfileid) {
		this.pfileid = pfileid;
	}

	public Date getPregtime() {
		return pregtime;
	}

	public void setPregtime(Date pregtime) {
		this.pregtime = pregtime;
	}

	public String getPoperator() {
		return poperator;
	}

	public void setPoperator(String poperator) {
		this.poperator = poperator;
	}

	
}
