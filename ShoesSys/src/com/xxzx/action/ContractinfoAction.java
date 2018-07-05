package com.xxzx.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xxzx.entity.Companyinfo;
import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Contype;
import com.xxzx.entity.Fileinfo;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Paymode;
import com.xxzx.entity.Role;
import com.xxzx.entity.Userinfo;
import com.xxzx.service.CompanyService;
import com.xxzx.service.ContractinfoService;
import com.xxzx.service.ContypeService;
import com.xxzx.service.FileuploadService;
import com.xxzx.util.Barbean;
import com.xxzx.util.ResultUtils;

public class ContractinfoAction extends ActionSupport implements
		ModelDriven<Contractinfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Contractinfo contractinfo = new Contractinfo();
	private Fundtype fundtype;
	private Companyinfo companyinfo;
	private Contype contype;
	private Confrom confrom;
	private Integer currPage = 1;
	private Userinfo userinfo1 = (Userinfo) ActionContext.getContext()
			.getSession().get("user");

	public Integer getCurrPage() {
		return currPage;
	}

	private String year = "2017";

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 注入业务层的类
	private ContractinfoService contractinfoService;
	private ContypeService contypeService;
	private CompanyService companyService;
	private FileuploadService fileuploadService;

	// get方法

	public FileuploadService getFileuploadService() {
		return fileuploadService;
	}

	public void setFileuploadService(FileuploadService fileuploadService) {
		this.fileuploadService = fileuploadService;
	}

	@Override
	public Contractinfo getModel() {
		// TODO Auto-generated method stub
		return contractinfo;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public void setContypeService(ContypeService contypeService) {
		this.contypeService = contypeService;
	}

	public void setContractinfoService(ContractinfoService contractinfoService) {
		this.contractinfoService = contractinfoService;
	}

	// 增加
	public String add() {

		String cfrom = "";
		String cb = "";
		String ctype = "";
		String cpayfrom = "";
		cfrom = (String) ServletActionContext.getRequest().getParameter(
				"select");
		cb = (String) ServletActionContext.getRequest().getParameter("scb");
		ctype = (String) ServletActionContext.getRequest().getParameter(
				"sctype");
		cpayfrom = (String) ServletActionContext.getRequest().getParameter(
				"sfundtype");
		// System.out.println("cfrom-" + cfrom);
		// System.out.println("cb-" + cb);
		// System.out.println("ctype-" + ctype);
		// System.out.println("cpayfrom-" + cpayfrom);

		contractinfo.setCpaid(0.0); // 初始化付款金额
		// 合同来源
		confrom = new Confrom();
		confrom.setCfid(Integer.valueOf(cfrom));
		contractinfo.setConfrom(confrom);
		// 公司信息
		companyinfo = new Companyinfo();
		companyinfo.setComid(Integer.valueOf(cb));
		contractinfo.setCompanyinfo(companyinfo);
		// 合同类型
		contype = new Contype();
		contype.setCtid(Integer.valueOf(ctype));
		contractinfo.setContype(contype);
		//资金来源
		fundtype=new Fundtype();
		fundtype.setFid(Integer.valueOf(cpayfrom));
		contractinfo.setFundtype(fundtype);
		
		
		contractinfo.setCpaid(0.0);
		contractinfo.setCdepartment(userinfo1.getDepartment().getDid());
		if (contractinfo != null) {
			int fid = Integer.valueOf(cpayfrom);
			fundtype = contypeService.findFundtypeById(fid);
			double fleft = 0.0;
			fleft = fundtype.getFcount() - contractinfo.getCcount();
			fundtype.setFleft(fleft);
			contypeService.updatefundtype(fundtype);
			contractinfoService.save(contractinfo);
		} else {

		}
		// ActionContext.getContext().put("con", contractinfo);
		return "addSuccess";
	}

	// 增加
	public String add2() {
		String cfrom = "";
		String cb = "";
		String ctype = "";
		String cpayfrom = "";
		cfrom = (String) ServletActionContext.getRequest().getParameter(
				"select");
		cb = (String) ServletActionContext.getRequest().getParameter("company");
		ctype = (String) ServletActionContext.getRequest().getParameter(
				"contype");
		cpayfrom = (String) ServletActionContext.getRequest().getParameter(
				"fundtype");

		contractinfo.setCpaid(0.0);
		// contractinfo.setCfrom(Integer.valueOf(cfrom));
		// contractinfo.setCb(Integer.valueOf(cb));
		// contractinfo.setCtype(Integer.valueOf(ctype));
		// contractinfo.setCpayfrom(Integer.valueOf(cpayfrom));
		contractinfoService.save(contractinfo);
		ActionContext.getContext().put("con", contractinfo);
		return "addSuccess2";
	}

	// 加载合同数
	public void counttotal() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		int count = contractinfoService.findtotal();
		String count1 = String.valueOf(count);
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(count1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行countall.action");
	}

	// 加载金额合同数
	public void paycounttotal() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		double count = contractinfoService.findsum("ccount");

		DecimalFormat df2 = null;
		df2 = (DecimalFormat) NumberFormat.getInstance();
		df2.applyPattern("#####,####.00");
		df2.format(count);
		System.out.println("count2====" + df2.format(count));
		String count1 = String.valueOf(df2.format(count));

		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(count1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("执行countall.action");
	}

	// 加载已付金额合同数
	public void paidcounttotal() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("UTF-8");
		double count = contractinfoService.findsum("cpaid");
		DecimalFormat df2 = null;
		df2 = (DecimalFormat) NumberFormat.getInstance();
		df2.applyPattern("#####,####.00");
		String count1 = String.valueOf(df2.format(count));
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(count1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("执行countall.action");
	}

	@RequiresRoles("admin")
	public String findAll() {
		PageBean<Contractinfo> pageBean2=new PageBean<Contractinfo>();
		PageBean<Contractinfo> pageBean = contractinfoService
				.findByPage(currPage);
		// 将pagebean存入值栈中
//
//		System.out.println("contract name1:" + userinfo1.getUloginname());
//		System.out.println("contract department"
//				+ userinfo1.getDepartment().getDname());
//		String rolevalue="";
//		for (Role role : userinfo1.getRoles()) {
//			System.out.println("角色" + role.getValue());
//			if(role.getValue().equals("admin"))
//			{
//				rolevalue="admin";
//				break;
//			}else if(role.getValue().equals("manage")){
//				rolevalue="manage";
//				break;
//			}else if(role.getValue().equals("custom")){
//				rolevalue="custom";
//				break;
//			}
//		}
		List<Contractinfo> contractinfos=new ArrayList<Contractinfo>();
		
		 contractinfos=contractinfoService.findall(userinfo1);
		 
		 ActionContext.getContext().put("cnums", 33);
		 ActionContext.getContext().put("ccount", 33);
		 ActionContext.getContext().put("cpaid", 33);
		//List<Contractinfo> contractinfos = pageBean.getList();
		// for (int i = 0; i < contractinfos.size(); i++) {
		// int fid = contractinfos.get(i).getCpayfrom();
		// //int comid = contractinfos.get(i).getCb();
		// // int cfid = contractinfos.get(i).getCfrom();
		// int ctid = contractinfos.get(i).getCtype();
		// fundtype = contypeService.findFundtypeById(fid);
		// //companyinfo = companyService.findById(comid);
		// contype = contypeService.findContyeById(ctid);
		// // confrom = contypeService.findConfromById(cfid);
		// contractinfos.get(i).setFundtype(fundtype);
		// //contractinfos.get(i).setCompanyinfo(companyinfo);
		// contractinfos.get(i).setContype(contype);
		// //contractinfos.get(i).setConfrom(confrom);
		// }

		pageBean2.setList(contractinfos);
		ActionContext.getContext().getValueStack().push(pageBean2);
		return "findAll";
	}

	public String findbyyear() {

		List<Contractinfo> contractinfos = contractinfoService.findByYear(year);
		// for (int i = 0; i < contractinfos.size(); i++) {
		// int fid = contractinfos.get(i).getCpayfrom();
		// int comid = contractinfos.get(i).getCb();
		// // int cfid = contractinfos.get(i).getCfrom();
		// int ctid = contractinfos.get(i).getCtype();
		// fundtype = contypeService.findFundtypeById(fid);
		// companyinfo = companyService.findById(comid);
		// contype = contypeService.findContyeById(ctid);
		// // confrom = contypeService.findConfromById(cfid);
		// contractinfos.get(i).setFundtype(fundtype);
		// contractinfos.get(i).setCompanyinfo(companyinfo);
		// contractinfos.get(i).setContype(contype);
		// contractinfos.get(i).setConfrom(confrom);
		// }

		PageBean<Contractinfo> pageBean = new PageBean<Contractinfo>();
		pageBean.setList(contractinfos);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	public void generCno() {
		contractinfo = contractinfoService.findmaxCno();
		String str = contractinfo.getCno().trim();
		String str1 = str.substring(0, str.length() - 3);
		String str2 = str.substring(str.length() - 3);
		int no = Integer.valueOf(str2);
		no = no + 1;
		String str3 = String.valueOf(no);
		if (str3.length() == 1)
			str3 = "00" + str3;
		else if (str3.length() == 2)
			str3 = "0" + str3;
		String cnoString = str1 + str3;

		PrintWriter out;
		try {
			out = ServletActionContext.getResponse().getWriter();
			out.print(cnoString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String findmodel() {
		List<Contractinfo> contractinfos = contractinfoService
				.findmodel(contractinfo);
		PageBean<Contractinfo> pageBean = new PageBean<Contractinfo>();
		pageBean.setList(contractinfos);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll2";
	}

	public String findAll2() {
		PageBean<Contractinfo> pageBean = contractinfoService
				.findByPage(currPage);
		// 将pagebean存入值栈中
		System.out.println("totalcount:" + pageBean.getTotalCount());
		ActionContext.getContext().getValueStack().push(pageBean);
		System.out.println("执行findAllAciton------");
		return "findAll2";
	}

	public String toadd() {
		return "toadd";
	}

	public String toadd2() {
		return "toadd2";
	}

	public void toJson() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Contractinfo> list = contractinfoService.findAllList();
		System.out.println("list size=" + list.size());
		if (list.size() > 0) {
			Contractinfo[] contractinfos = new Contractinfo[list.size()];
			for (int i = 0; i < list.size(); i++) {
				contractinfos[i] = list.get(i);
			}
			map.put("contract", contractinfos);
		}
		System.out.println("list size2=" + list.size());
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 按年度展示合同额
	public void toBarJson() {
		// var barChartData = {
		// labels : [ "January", "February", "March", "April", "May", "June",
		// "July", "July" ],
		// datasets : [ {
		// label : '数据1',
		// backgroundColor : "#FFE4B5",
		// borderColor : "#FFA54F",
		// borderWidth : 1,
		// data : [ 110, randomScalingFactor(), randomScalingFactor(),
		// randomScalingFactor(), randomScalingFactor(),
		// randomScalingFactor(), randomScalingFactor(), 22 ]
		// } ]
		//
		// };

		Map<String, Object> map = new HashMap<String, Object>();
		List<String> labels = new ArrayList<String>();
		List<Map> datasets = new ArrayList<Map>();
		Map<String, Object> submap = new HashMap<String, Object>();
		Map<String, Object> submap2 = new HashMap<String, Object>();
		List<Double> data = new ArrayList<Double>();
		List<Integer> data2 = new ArrayList<Integer>();
		List<Barbean> list = contractinfoService.findcountByYear();
		for (int i = 0; i < list.size(); i++) {
			labels.add(list.get(i).getYear() + "年");
			data.add(list.get(i).getSumcount());
			data2.add(list.get(i).getCount());
		}
		submap.put("label", "合同总额");
		submap.put("backgroundColor", "#FFE4B5");
		submap.put("borderColor", "#FFA54F");
		submap.put("borderWidth", 1);
		submap.put("data", data);
		submap2.put("label", "合同数");
		submap2.put("backgroundColor", "#9BCD9B");
		submap2.put("borderColor", "#969696");
		submap2.put("borderWidth", 1);
		submap2.put("data", data2);
		datasets.add(submap);
		datasets.add(submap2);

		map.put("labels", labels);
		map.put("datasets", datasets);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void toPieJson() {
		// var config = {
		// type : 'pie',
		// data : {
		// datasets : [ {
		// data : [ 11, 22, 33, 44, ],
		// backgroundColor : [ "#FF6347", window.chartColors.orange,
		// window.chartColors.green, window.chartColors.blue, ],
		//
		// } ],
		// labels : [ "2015年", "2016年", "2017年", "2018年", ]
		// },
		// options : {
		// responsive : true
		// }
		// };
		Map<String, Object> config = new HashMap<String, Object>();
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> options = new HashMap<String, Object>();
		options.put("responsive", true);
		String[] colors = new String[] { "#F38630", "#E0E4CC", "#69D2E7",
				"#6E8B3D", "#EE9A00" };
		List<Fundtype> fundtypes = contypeService.findfundlist();
		String[] subbackgroundColor = new String[fundtypes.size()];
		Double[] subdata = new Double[fundtypes.size()];
		String[] sublabels = new String[fundtypes.size()];

		List<Map> datasets = new ArrayList<Map>();
		Map<String, Object> data = new HashMap<String, Object>();

		for (int i = 0; i < fundtypes.size(); i++) {
			subbackgroundColor[i] = colors[i % colors.length];
			subdata[i] = fundtypes.get(i).getFcount();
			sublabels[i] = fundtypes.get(i).getFtype();
		}
		data.put("data", subdata);
		data.put("backgroundColor", subbackgroundColor);
		datasets.add(data);

		map.put("datasets", datasets);
		map.put("labels", sublabels);
		config.put("data", map);
		config.put("type", "pie");
		config.put("options", options);
		try {
			ResultUtils.toJson(ServletActionContext.getResponse(), config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String findAllList() {
		List<Contractinfo> list = contractinfoService.findAllList();
		ActionContext.getContext().getValueStack().push(list);
		System.out.println("listsize" + list.size());
		return "findAll";
	}

	public String index() {
		return "index";
	}

	public String toshow() {
		return "toshow";
	}

	public String delete() {
		contractinfo = contractinfoService.findById(contractinfo.getCid());
		contractinfoService.delete(contractinfo);
		System.out.println("===执行delete()===cid=" + contractinfo.getCid());
		return "delete";
	}

	public String delete2() {
		contractinfo = contractinfoService.findById(contractinfo.getCid());
		System.out.println("cid====" + contractinfo.getCid());
		contractinfoService.delete(contractinfo);
		System.out.println("===执行delete()===cid=" + contractinfo.getCid());
		return "delete2";
	}

	// 查看单个合同信息
	public String find() {
		contractinfo = contractinfoService.findById(contractinfo.getCid());
		PageBean<Payinfo> pageBean2 = new PageBean<Payinfo>();
		String str = "cid";
		// int fid = contractinfo.getCpayfrom();
		// // int comid = contractinfo.getCb();
		// // int cfid = contractinfo.getCfrom();
		// int ctid = contractinfo.getCtype();
		// fundtype = contypeService.findFundtypeById(fid);
		// // companyinfo = companyService.findById(comid);
		// contype = contypeService.findContyeById(ctid);
		// // confrom = contypeService.findConfromById(cfid);
		// contractinfo.setFundtype(fundtype);
		// contractinfo.setCompanyinfo(companyinfo);
		// contractinfo.setContype(contype);
		// contractinfo.setConfrom(confrom);
		List<Payinfo> payinfos = contypeService.findPayByCid(str,
				contractinfo.getCid());
		List<Paymode> paymodes = contypeService.findPayModeByCid(contractinfo
				.getCid());
		List<Fileinfo> fileinfos = fileuploadService
				.findFileinfoByCid(contractinfo.getCid());
		double paycount = 0;
		for (int i = 0; i < payinfos.size(); i++) {
			payinfos.get(i).setContractinfo(contractinfo);
			paycount += payinfos.get(i).getPpay();
		}
		pageBean2.setList(payinfos);
		pageBean2.setPaycount(paycount);
		ActionContext.getContext().getValueStack().push(pageBean2);
		// for(int i=0;i<paymodes.size();i++){
		// System.out.println("percent=="+paymodes.get(i).getPmpercent());
		// }
		ActionContext.getContext().getValueStack().set("paymodes", paymodes);
		ActionContext.getContext().getValueStack().set("filelist", fileinfos);
		return "findinfo";
	}

	public String edit() {
		contractinfo = contractinfoService.findById(contractinfo.getCid());

		return "edit";
	}

	public String edit2() {
		contractinfo = contractinfoService.findById(contractinfo.getCid());
		return "edit2";
	}

	public String toindex() {

		PageBean<Contractinfo> pageBean = contractinfoService
				.findByPage(currPage);
		// 将pagebean存入值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "toindex";
	}

	public String update() {
		String cfrom = "";
		String cb = "";
		String ctype = "";
		String cpayfrom = "";
		// 参照add()
		// cfrom = (String) ServletActionContext.getRequest().getParameter(
		// "sselect");
		// cb = (String) ServletActionContext.getRequest()
		// .getParameter("scompany");
		// ctype = (String) ServletActionContext.getRequest().getParameter(
		// "scontype");
		// cpayfrom = (String) ServletActionContext.getRequest().getParameter(
		// "sfundtype");
		// if (!cfrom.equals("")) {
		// contractinfo.setCfrom(Integer.valueOf(cfrom));
		// }
		// if (!cb.equals("")) {
		// contractinfo.setCb(Integer.valueOf(cb));
		// }
		// if (!ctype.equals("")) {
		// contractinfo.setCtype(Integer.valueOf(ctype));
		// }
		// if (!ctype.equals("")) {
		// contractinfo.setCpayfrom(Integer.valueOf(cpayfrom));
		// }
		Date date = new Date();
		contractinfo.setCregtime(date);
		System.out.println("date===" + date);
		System.out.println("regdate===" + contractinfo.getCregtime());
		contractinfoService.update(contractinfo);
		return "update";
	}

	public String update2() {
		System.out.println("cno===" + contractinfo.getCno());
		Date date = new Date();
		contractinfo.setCregtime(date);
		System.out.println("date===" + date);
		System.out.println("regdate===" + contractinfo.getCregtime());
		contractinfoService.update(contractinfo);
		return "update2";
	}
}
