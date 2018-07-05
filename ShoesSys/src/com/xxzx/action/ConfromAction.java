package com.xxzx.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Contype;
import com.xxzx.entity.PageBean;
import com.xxzx.service.ContypeService;
import com.xxzx.util.ResultUtils;

public class ConfromAction extends ActionSupport implements
		ModelDriven<Confrom> {
	private Confrom confrom = new Confrom();
	private ContypeService contypeService;

	public void setContypeService(ContypeService contypeService) {
		this.contypeService = contypeService;
	}

	@Override
	public Confrom getModel() {
		// TODO Auto-generated method stub
		return confrom;
	}

	public String add() {
		contypeService.saveconfrom(confrom);
		return "addSuccess";
	}

	public String toadd() {
		return "toadd";
	}

	public String delete() {
		confrom = contypeService.findConfromById(confrom.getCfid());
		contypeService.deleteconfrom(confrom);

		return "delete";
	}

	public String edit() {
		confrom = contypeService.findConfromById(confrom.getCfid());

		return "edit";
	}

	public String update() {
		contypeService.updateconfrom(confrom);

		return "update";
	}
	public void toJson() {

		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Confrom> list = contypeService.findalllistconfrom();
	
		if (list.size() > 0) {
			Confrom[] confroms=new Confrom[list.size()];
			for (int i = 0; i < list.size(); i++) {
				 confroms[i]=list.get(i);
			}
			map.put("confrom", confroms);
		}
		
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String findAll() {

		PageBean<Confrom> pageBean = contypeService.findallconfrom();
		// // 将pagebean存入值栈中
		// System.out.println("totalcount:"+pageBean.getTotalCount());
		ActionContext.getContext().getValueStack().push(pageBean);
		// System.out.println("执行findAllAciton------");
		return "findAll";
	}
	// public void findList()
	// {
	// Map<String, Object> map = new HashMap<String, Object>();
	// List<Confrom> list=contypeService.findcontype();
	// if (list.size() > 0) {
	// for(int i=0;i<list.size();i++)
	// map.put(String.valueOf(i), list.get(i));
	// }
	// try {
	// ResultUtils.toJson(ServletActionContext.getResponse(), map);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	//
	//
	// }

}
