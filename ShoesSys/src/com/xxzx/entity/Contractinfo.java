package com.xxzx.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;



public class Contractinfo {
	@Expose
	private Integer cid;//id
	@Expose
	private String cno;//合同编号
	@Expose
	private String cname;//合同名称
	//private Integer cfrom;//合同来源
	//private Integer ctype;//合同类型
	private String ca;// 甲方
	//private Integer cb;//乙方
	private Double ccount;//合同金额
	private Date ctime;//签约日期
	private Date cworktime;//开工日期
	private Date cfinishtime;//合同约定日期
	private String coperator;//经办人
	private  String cpayinfo;//付款说明
	//private Integer cpayfrom;// 资金来源
	private  Double cpaid;//已付款
	private Double cunpaid;//未付款
	private String cpayprogress;//付款进度
	private Integer cdepartment;//所属部门
	
	private String csuboffice;//所属科室
	private Integer cqamonth;//质保年限
	private Integer cisqa;//是否续保 0 否，1是
	private Double cqacount;//续保金额
	private Date cqadate;//续保时间
	private String constatue;//验收状态
	private Double conbzj;//保证金
	private String conbzjstatue;//保证金是否退，
	private Date cregtime;//登记时间
	private String cuser;//操作人
	private String cmore;//备注
	//外键
	private Set<Payinfo> payinfos= new HashSet<Payinfo>();
	
	//外键 多对一
	//一方
	private Confrom confrom; //合同来源
	private Companyinfo companyinfo;//公司信息
	private Contype contype; //合同类型
	private Fundtype fundtype; //资金类型
	private Paymode paymode; //付款模式
	private Userinfo userinfo; //用户信息
	
	public Userinfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	public Set<Payinfo> getPayinfos() {
		return payinfos;
	}
	public void setPayinfos(Set<Payinfo> payinfos) {
		this.payinfos = payinfos;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
 
	
	public String getConstatue() {
		return constatue;
	}
	public void setConstatue(String constatue) {
		this.constatue = constatue;
	}
	public Double getConbzj() {
		return conbzj;
	}

	public Integer getCdepartment() {
		return cdepartment;
	}
	public void setCdepartment(Integer cdepartment) {
		this.cdepartment = cdepartment;
	}
	public String getCsuboffice() {
		return csuboffice;
	}
	public void setCsuboffice(String csuboffice) {
		this.csuboffice = csuboffice;
	}

	public Integer getCisqa() {
		return cisqa;
	}
	public void setCisqa(Integer cisqa) {
		this.cisqa = cisqa;
	}
	public Double getCqacount() {
		return cqacount;
	}
	public void setCqacount(Double cqacount) {
		this.cqacount = cqacount;
	}
	
	public Integer getCqamonth() {
		return cqamonth;
	}
	
//	public Integer getCfrom() {
//		return cfrom;
//	}
//	public void setCfrom(Integer cfrom) {
//		this.cfrom = cfrom;
//	}

	
//	public Integer getCpayfrom() {
//		return cpayfrom;
//	}
//	public void setCpayfrom(Integer cpayfrom) {
//		this.cpayfrom = cpayfrom;
//	}
	public Confrom getConfrom() {
		return confrom;
	}
	public void setConfrom(Confrom confrom) {
		this.confrom = confrom;
	}
	public Companyinfo getCompanyinfo() {
		return companyinfo;
	}
	public void setCompanyinfo(Companyinfo companyinfo) {
		this.companyinfo = companyinfo;
	}
	public Contype getContype() {
		return contype;
	}
	public void setContype(Contype contype) {
		this.contype = contype;
	}
	public Fundtype getFundtype() {
		return fundtype;
	}
	public void setFundtype(Fundtype fundtype) {
		this.fundtype = fundtype;
	}
	public void setCqamonth(Integer cqamonth) {
		this.cqamonth = cqamonth;
	}
	public Date getCqadate() {
		return cqadate;
	}
	public void setCqadate(Date cqadate) {
		this.cqadate = cqadate;
	}
	public void setConbzj(Double conbzj) {
		this.conbzj = conbzj;
	}
	public String getConbzjstatue() {
		return conbzjstatue;
	}
	public void setConbzjstatue(String conbzjstatue) {
		this.conbzjstatue = conbzjstatue;
	}
 
	public String getCa() {
		return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
 
	public Double getCcount() {
		return ccount;
	}
	public void setCcount(Double ccount) {
		this.ccount = ccount;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getCworktime() {
		return cworktime;
	}
	public void setCworktime(Date cworktime) {
		this.cworktime = cworktime;
	}
	public Date getCfinishtime() {
		return cfinishtime;
	}
	public void setCfinishtime(Date cfinishtime) {
		this.cfinishtime = cfinishtime;
	}
	public String getCoperator() {
		return coperator;
	}
	public void setCoperator(String coperator) {
		this.coperator = coperator;
	}
	public String getCpayinfo() {
		return cpayinfo;
	}
	public void setCpayinfo(String cpayinfo) {
		this.cpayinfo = cpayinfo;
	}
	 
	public Double getCpaid() {
		return cpaid;
	}
	public void setCpaid(Double cpaid) {
		this.cpaid = cpaid;
	}
	public Double getCunpaid() {
		return cunpaid;
	}
	public void setCunpaid(Double cunpaid) {
		this.cunpaid = cunpaid;
	}
	public String getCpayprogress() {
		return cpayprogress;
	}
	public void setCpayprogress(String cpayprogress) {
		this.cpayprogress = cpayprogress;
	}

	public Date getCregtime() {
		return cregtime;
	}
	public void setCregtime(Date cregtime) {
		this.cregtime = cregtime;
	}
	public String getCuser() {
		return cuser;
	}
	public void setCuser(String cuser) {
		this.cuser = cuser;
	}
	public String getCmore() {
		return cmore;
	}
	public void setCmore(String cmore) {
		this.cmore = cmore;
	}
	public Paymode getPaymode() {
		return paymode;
	}
	public void setPaymode(Paymode paymode) {
		this.paymode = paymode;
	}
	
	
	
	
}
