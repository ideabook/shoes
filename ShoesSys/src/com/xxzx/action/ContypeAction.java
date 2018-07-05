package com.xxzx.action;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxzx.entity.Companyinfo;
import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Contype;
import com.xxzx.entity.PageBean;
import com.xxzx.service.CompanyService;
import com.xxzx.service.ContractinfoService;
import com.xxzx.service.ContypeService;
import com.xxzx.util.ResultUtils;

public class ContypeAction extends ActionSupport implements
		ModelDriven<Contype> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Contype contype=new Contype();
	private Integer currPage = 1;
	
	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	private ContypeService contypeService;
	


	public void setContypeService(ContypeService contypeService) {
		this.contypeService = contypeService;
	}

	// 增加
	public String add() {
		contypeService.save(contype);
		System.out.println("类型是："+contype.getCttype());
		System.out.println("备注是："+contype.getCtmore());
		return "addSuccess";
	}
	public void toJson() {

		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Contype> list = contypeService.findalllistContype();
	
		if (list.size() > 0) {
			Contype[] contypes=new Contype[list.size()];
			for (int i = 0; i < list.size(); i++) {
				 contypes[i]=list.get(i);
			}
			map.put("contype", contypes);
		}
		
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String findAll() {
		
		PageBean<Contype> pageBean = contypeService
				.findByPage(currPage);
//		// 将pagebean存入值栈中
//		System.out.println("totalcount:"+pageBean.getTotalCount());
		ActionContext.getContext().getValueStack().push(pageBean);
//		System.out.println("执行findAllAciton------");
		return "findAll";
	}
	
	public String index(){
		System.out.println("执行indexAciton------");
		return "index";
	}
	//
	public String toadd()
	{
		return "toadd";
	}
	public String delete()
	{
		contype=contypeService.findContyeById(contype.getCtid());
		contypeService.delete(contype);
		
		return "delete";
	}
	public String edit()
	{
		contype=contypeService.findContyeById(contype.getCtid());
		
		return "edit";
	}
	public String update()
	{	System.out.println("type=="+contype.getCttype());
	System.out.println("more="+contype.getCttype());
		contypeService.update(contype);
		
		return "update";
	}
	@Override
	public Contype getModel() {
		// TODO Auto-generated method stub
		return contype;
	}


}
