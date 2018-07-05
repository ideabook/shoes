package com.xxzx.action;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxzx.entity.Companyinfo;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Contype;
import com.xxzx.entity.PageBean;
import com.xxzx.service.CompanyService;
import com.xxzx.service.ContractinfoService;
import com.xxzx.util.ResultUtils;

public class CompanyAction extends ActionSupport implements
		ModelDriven<Companyinfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Companyinfo companyinfo = new Companyinfo();
	private Integer currPage = 1;

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	private CompanyService companyService;

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	// 增加
	public String add() {
		Date date = new Date();
		companyinfo.setComregtime(date);
		companyService.save(companyinfo);
		return "addSuccess";
	}

	public String findAll() {
		// PageBean<Contractinfo> pageBean = contractinfoService
		// .findByPage(currPage);
		// // 将pagebean存入值栈中
		PageBean<Companyinfo> pageBean = companyService.findAll();
		// System.out.println("totalcount:"+pageBean.getTotalCount());
		ActionContext.getContext().getValueStack().push(pageBean);
		// System.out.println("执行findAllAciton------");
		return "findAll";
	}

	public void toJson() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Companyinfo> list = companyService.findalllist();

		if (list.size() > 0) {
			Companyinfo[] companyinfos = new Companyinfo[list.size()];
			for (int i = 0; i < list.size(); i++) {
				companyinfos[i] = list.get(i);
			}
			map.put("cb", companyinfos);
		}

		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String index() {
		System.out.println("执行indexAciton------");
		return "index";
	}

	public String toadd() {

		return "toadd";
	}

	public String edit() {
		companyinfo = companyService.findById(companyinfo.getComid());

		return "edit";
	}

	public String update() {
		Date date = new Date();
		companyinfo.setComregtime(date);
		companyService.update(companyinfo);

		return "update";
	}

	public String delete() {
		companyinfo = companyService.findById(companyinfo.getComid());
		companyService.delete(companyinfo);

		return "delete";
	}

	public Companyinfo getModel() {
		// TODO Auto-generated method stub
		return companyinfo;
	}
}
