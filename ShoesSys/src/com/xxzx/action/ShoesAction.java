package com.xxzx.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.xxzx.entity.Contractinfo;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.Gpsinfo;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Role;
import com.xxzx.entity.ShoesStatus;
import com.xxzx.entity.Userinfo;
import com.xxzx.service.ContractinfoService;
import com.xxzx.service.ContypeService;
import com.xxzx.service.ShoesService;
import com.xxzx.util.ResultUtils;

public class ShoesAction extends ActionSupport implements
		ModelDriven<ShoesStatus> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ShoesStatus shoesstatus = new ShoesStatus();
	private Payinfo payinfo = new Payinfo();

	private ContypeService contypeService;
	private ContractinfoService contractinfoService;
	private ShoesService shoesService;
	private Contractinfo contractinfo;
	private Fundtype fundtype;

	private String sdate;
	private String userName1;
	private String passWord;
	private Userinfo userinfo = new Userinfo();

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public ShoesService getShoesService() {
		return shoesService;
	}

	public void setShoesService(ShoesService shoesService) {
		this.shoesService = shoesService;
	}

	public void setContractinfoService(ContractinfoService contractinfoService) {
		this.contractinfoService = contractinfoService;
	}

	public void setContypeService(ContypeService contypeService) {
		this.contypeService = contypeService;
	}

	public String addstep() {
		System.out.println("sdate:" + sdate);
		if (sdate == null || sdate.equals("")) {
			Date date = new Date();
			System.out.println("time:" + date);
			shoesstatus.setStime(date);

		} else {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				shoesstatus.setStime(sdf.parse(sdate));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		List<ShoesStatus> shoesStatus = shoesService.findcurrent(shoesstatus);
		System.out.println("size:"+shoesStatus.size());
		if (shoesStatus.size() > 0) {
			shoesstatus.setSid(shoesStatus.get(0).getSid());
			shoesService.updateshoesstatus(shoesstatus);
			Gpsinfo gpsinfo=new Gpsinfo();
			gpsinfo.setLongitude(shoesstatus.getLongitude());
			gpsinfo.setLatitude(shoesstatus.getLatitude());
			gpsinfo.setGdate(shoesstatus.getStime());
			gpsinfo.setShoesStatus(shoesstatus);
			shoesService.saveGpsinfo(gpsinfo);
		} else {
			shoesService.save(shoesstatus);
			Gpsinfo gpsinfo=new Gpsinfo();
			gpsinfo.setLongitude(shoesstatus.getLongitude());
			gpsinfo.setLatitude(shoesstatus.getLatitude());
			gpsinfo.setGdate(shoesstatus.getStime());
			gpsinfo.setShoesStatus(shoesstatus);
			shoesService.saveGpsinfo(gpsinfo);
		}
		
		return "addsuccess";
	}

	public String touseradd() {

		return "touseradd";
	}

	public String togps() {

		return "togps";
	}
	public String getcurrentgps()
	{
		List<Gpsinfo> gpsinfos=new ArrayList<Gpsinfo>();
		gpsinfos=shoesService.findcurrentgps(shoesstatus.getSid(),shoesstatus.getStime());
		System.out.println("gsize:"+gpsinfos);
		for(Gpsinfo gpsinfo:gpsinfos)
		{
			System.out.println("纬度："+gpsinfo.getLatitude());
		}
		
		
		return "";
	}
	public void userreg() {
		List<Userinfo> list = shoesService.finduser(shoesstatus.getUserName());
		Map<String, Object> map = new HashMap<String, Object>();
		if (list.size() > 0 || list == null) {
			System.out.println("不可以注册");
			ActionContext.getContext().put("msg", "用户名重复");
			map.put("result:", "0");
		} else {
			System.out.println("可以注册");
			map.put("result:", "1");
			userinfo.setUloginname(shoesstatus.getUserName());
			if (passWord != null || !passWord.equals("")) {
				userinfo.setUpassword(passWord);
			}
			shoesService.adduser(userinfo);
		}

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

	public String userreg2() {
		List<Userinfo> list = shoesService.finduser(shoesstatus.getUserName());
		if (list.size() > 0 || list == null) {
			System.out.println("不可以注册");
			ActionContext.getContext().put("msg", "用户名重复");
			return "reg";
		} else {
			System.out.println("可以注册");
			userinfo.setUloginname(shoesstatus.getUserName());
			if (passWord != null || !passWord.equals("")) {
				userinfo.setUpassword(passWord);
			}
			Set<Role> roles = new HashSet<Role>();
			Role role = new Role();
			role.setId(2);
			roles.add(role);
			userinfo.setRoles(roles);
			shoesService.adduser(userinfo);
			return "tologin";
		}

	}

	public String add() {
		String cid = "";
		cid = (String) ServletActionContext.getRequest().getParameter("pay");
		Integer cid2 = Integer.valueOf(cid);
		String paypercent = "";
		paypercent = (String) ServletActionContext.getRequest().getParameter(
				"paypercent");
		Integer paypercent2 = Integer.valueOf(paypercent);

		System.out.println("cid=" + cid);
		System.out.println("cid2=" + cid2);
		contractinfo = contractinfoService.findById(cid2);

		// System.out.println(payinfo.getPpay());
		// System.out.println(contractinfo.getCpaid());
		// System.out.println("paypercet= "+paypercent2);
		double pay = 0;
		if (payinfo.getPpay() != null) {
			pay = contractinfo.getCpaid() + payinfo.getPpay();
		} else if (paypercent2 != null || paypercent2 != 0) {
			payinfo.setPpay(contractinfo.getCcount() * paypercent2 / 100);
			pay = contractinfo.getCpaid() + contractinfo.getCcount()
					* paypercent2 / 100;
		}
		if (payinfo.getPdate() == null) {
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

	public String findAllShoes() {

		List<ShoesStatus> list = shoesService.find();
		// for (int i = 0; i < payinfos.size(); i++) {
		// Integer cid = payinfos.get(i).getCid();
		// contractinfo = contractinfoService.findById(cid);
		// payinfos.get(i).setContractinfo(contractinfo);
		//
		// }
		// pageBean.setList(payinfos);
		System.out.println("shoesize:"+list.size());
		ActionContext.getContext().getValueStack().set("status", list);
		return "find";
	}

	public String findAll() {
		PageBean<Payinfo> pageBean = contypeService.findPayinfo();
		List<Payinfo> payinfos = pageBean.getList();
		// for (int i = 0; i < payinfos.size(); i++) {
		// Integer cid = payinfos.get(i).getCid();
		// contractinfo = contractinfoService.findById(cid);
		// payinfos.get(i).setContractinfo(contractinfo);
		//
		// }
		// pageBean.setList(payinfos);
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
		fundtype = contypeService.findFundtypeById(contractinfo.getFundtype()
				.getFid());
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

	public String findcid() {
		PageBean<Payinfo> pageBean = new PageBean<Payinfo>();
		List<Payinfo> payinfos = contypeService.findPayByCid("cid",
				payinfo.getCid());

		pageBean.setList(payinfos);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}

	@Override
	public ShoesStatus getModel() {
		// TODO Auto-generated method stub
		return shoesstatus;
	}

	public String getUserName1() {
		return userName1;
	}

	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}

}
