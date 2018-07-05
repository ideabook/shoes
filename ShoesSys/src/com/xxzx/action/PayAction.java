package com.xxzx.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Userinfo;
import com.xxzx.service.ContractinfoService;
import com.xxzx.service.ContypeService;

public class PayAction extends ActionSupport implements ModelDriven<Payinfo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Payinfo payinfo = new Payinfo();
	private ContypeService contypeService;
	private ContractinfoService contractinfoService;
	private Contractinfo contractinfo;
	private Fundtype fundtype;

	public void setContractinfoService(ContractinfoService contractinfoService) {
		this.contractinfoService = contractinfoService;
	}

	public void setContypeService(ContypeService contypeService) {
		this.contypeService = contypeService;
	}

	public String add() {
		String cid = "";
		cid = (String) ServletActionContext.getRequest().getParameter("pay");
		Integer cid2 = Integer.valueOf(cid);
		String paypercent="";
		paypercent = (String) ServletActionContext.getRequest().getParameter("paypercent");
		Integer paypercent2=Integer.valueOf(paypercent);
		
		System.out.println("cid=" + cid);
		System.out.println("cid2=" + cid2);
		contractinfo = contractinfoService.findById(cid2);

//		System.out.println(payinfo.getPpay());
//		System.out.println(contractinfo.getCpaid());
//		System.out.println("paypercet= "+paypercent2);
		double pay=0;
		if(payinfo.getPpay()!=null){
			pay = contractinfo.getCpaid() + payinfo.getPpay();	
		}else if(paypercent2!=null||paypercent2!=0)
		{
			payinfo.setPpay(contractinfo.getCcount()*paypercent2/100);
			pay=contractinfo.getCpaid()+contractinfo.getCcount()*paypercent2/100;
		}
		if(payinfo.getPdate()==null)
		{
			Date d1 = new Date();
			payinfo.setPdate(d1);
		}
		contractinfo.setCpaid(pay);
		contractinfoService.update(contractinfo);
		payinfo.setCid(cid2);
		Map<String, Object> session = ActionContext.getContext().getSession();
		Userinfo userinfo = (Userinfo) session.get("user");
		payinfo.setPoperator(userinfo.getUname());
		payinfo.setContractinfo(contractinfo);
		contypeService.savePayinfo(payinfo);

		return "addSuccess";
	}

	public String findAll() {
		PageBean<Payinfo> pageBean = contypeService.findPayinfo();
		List<Payinfo> payinfos = pageBean.getList();
//		for (int i = 0; i < payinfos.size(); i++) {
//			Integer cid = payinfos.get(i).getCid();
//			contractinfo = contractinfoService.findById(cid);
//			payinfos.get(i).setContractinfo(contractinfo);
//
//		}
//		pageBean.setList(payinfos);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	public String toadd() {
		return "toadd";
	}

	public String delete() {
		payinfo = contypeService.findPayById(payinfo.getPid());
		int cid2 = Integer.valueOf(payinfo.getContractinfo().getCid());
		double pay = payinfo.getPpay();
		contractinfo = contractinfoService.findById(cid2);
		fundtype = contypeService.findFundtypeById(contractinfo.getFundtype().getFid());
		double fcount = fundtype.getFcount();
		double paid = contractinfo.getCpaid();
		double newpay = paid - pay;
		double newfcount = fcount + pay;
		contractinfo.setCpaid(newpay);
		contractinfoService.update(contractinfo);
		fundtype.setFcount(newfcount);
		contypeService.updatefundtype(fundtype);
		contypeService.deletepay(payinfo);
		return "delete";
	}
	public String findcid(){
		PageBean<Payinfo> pageBean = new PageBean<Payinfo>();
		List<Payinfo> payinfos=contypeService.findPayByCid("cid", payinfo.getCid());
		
		pageBean.setList(payinfos);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	@Override
	public Payinfo getModel() {
		// TODO Auto-generated method stub
		return payinfo;
	}

}
