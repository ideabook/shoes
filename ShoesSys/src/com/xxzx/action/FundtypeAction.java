package com.xxzx.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxzx.entity.Companyinfo;
import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Contype;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.PageBean;
import com.xxzx.service.CompanyService;
import com.xxzx.service.ContractinfoService;
import com.xxzx.service.ContypeService;
import com.xxzx.util.ResultUtils;

public class FundtypeAction extends ActionSupport implements
		ModelDriven<Fundtype> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Fundtype fundtype = new Fundtype();
	private ContypeService contypeService;
	private Companyinfo companyinfo;
	// 注入业务层的类
	private ContractinfoService contractinfoService;
	private CompanyService companyService;

	

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public void setContractinfoService(ContractinfoService contractinfoService) {
		this.contractinfoService = contractinfoService;
	}

	public void setContypeService(ContypeService contypeService) {
		this.contypeService = contypeService;
	}

	public String add() {
		double fleft=fundtype.getFcount();
		fundtype.setFleft(fleft);
		contypeService.savefundtype(fundtype);
		
		return "addSuccess";
	}

	public String toadd() {
		return "toadd";
	}

	public String delete() {
		fundtype = contypeService.findFundtypeById(fundtype.getFid());
		contypeService.deletefundtype(fundtype);

		return "delete";
	}

	public String edit() {
		fundtype = contypeService.findFundtypeById(fundtype.getFid());

		return "edit";
	}

	public String update() {
		contypeService.updatefundtype(fundtype);

		return "update";
	}

	public void toJson() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Fundtype> list = contypeService.findfundlist();

		if (list.size() > 0) {
			Fundtype[] fundtypes = new Fundtype[list.size()];
			for (int i = 0; i < list.size(); i++) {
				fundtypes[i] = list.get(i);
			}
			map.put("fundtype", fundtypes);
		}

		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String findAll() {

		PageBean<Fundtype> pageBean = contypeService.findallfundtype();
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	public String find() {

		fundtype = contypeService.findFundtypeById(fundtype.getFid());
		int cpayfrom = fundtype.getFid();
		Contractinfo contractinfo = new Contractinfo();
		//contractinfo.setCpayfrom(cpayfrom);
		contractinfo.setFundtype(fundtype);
		PageBean<Contractinfo> pageBean = new PageBean<Contractinfo>();
		List<Contractinfo> list = contractinfoService.findmodel(contractinfo);
		double paycount = 0;
		for (int i = 0; i < list.size(); i++) {
			//int comid = list.get(i).getCb();
		//	companyinfo = companyService.findById(comid);
			//list.get(i).setCompanyinfo(companyinfo);
			paycount += list.get(i).getCcount();
		}
		pageBean.setList(list);
		pageBean.setPaycount(paycount);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "find";
	}

	@Override
	public Fundtype getModel() {
		// TODO Auto-generated method stub
		return fundtype;
	}

}
