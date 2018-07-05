package com.xxzx.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Paymode;
import com.xxzx.service.ContractinfoService;
import com.xxzx.service.ContypeService;

public class PaymodeAction extends ActionSupport implements
		ModelDriven<Paymode> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Paymode paymode = new Paymode();
	private ContypeService contypeService;
	private ContractinfoService contractinfoService;
	private Contractinfo contractinfo;
	private Fundtype fundtype;
	private List<Paymode> paymodes;

	public List<Paymode> getPaymodes() {
		return paymodes;
	}

	public void setPaymodes(List<Paymode> paymodes) {
		this.paymodes = paymodes;
	}

	public void setContractinfoService(ContractinfoService contractinfoService) {
		this.contractinfoService = contractinfoService;
	}

	public void setContypeService(ContypeService contypeService) {
		this.contypeService = contypeService;
	}

	public String add() {

		System.out.println("执行了Add的默认方法");

		String cid = "";
		cid = (String) ServletActionContext.getRequest().getParameter("pay");
		Integer cid2 = Integer.valueOf(cid);
		// paymode.setCid(cid2);
		for (Paymode s : paymodes) {
			if (s.getPmpercent() != null&& s.getPmtype()!=null) {
				s.setCid(cid2);
				Contractinfo contractinfo = contractinfoService.findById(cid2);
				if (s.getPmpercent() != null) {
					s.setPmcount(s.getPmpercent() * contractinfo.getCcount()
							/ 100);
				}
				if (s.getPmcount() != null) {
					s.setPmpercent(s.getPmcount() / contractinfo.getCcount()
							* 100);
				}
				contypeService.savePaymode(s);
			}
			System.out.println(s);
		}

		// contypeService.savePaymode(paymode);

		return "addSuccess";
	}

	public String findAll() {
		PageBean<Paymode> pageBean = contypeService.findPayode();
		List<Paymode> list = pageBean.getList();
		for (int i = 0; i < list.size(); i++) {
			Integer cid = list.get(i).getCid();
			contractinfo = contractinfoService.findById(cid);
			list.get(i).setContractinfo(contractinfo);
		}
		pageBean.setList(list);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	public String toadd() {
		return "toadd";
	}

	public String delete() {

		paymode = contypeService.findPaymodeById(paymode.getPmid());
		contypeService.deletepaymode(paymode);
		return "delete";
	}

	@Override
	public Paymode getModel() {
		// TODO Auto-generated method stub
		return paymode;
	}

}
