package com.xxzx.service.impl;

import java.util.Date;
import java.util.List;

import com.xxzx.dao.ShoesDao;
import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contype;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.Gpsinfo;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Paymode;
import com.xxzx.entity.ShoesStatus;
import com.xxzx.entity.Userinfo;

import com.xxzx.service.ShoesService;

public class ShoesServiceImpl implements ShoesService{
	
	private ShoesDao shoesDao;
	
	public ShoesDao getShoesDao() {
		return shoesDao;
	}

	public void setShoesDao(ShoesDao ShoesDao) {
		this.shoesDao = ShoesDao;
	}
   
	

	@Override
	public void saveconfrom(Confrom confrom) {
		shoesDao.saveconfrom(confrom);
		
	}

	@Override
	public void savePayinfo(Payinfo payinfo) {
		shoesDao.savePayinfo(payinfo);
	}

	@Override
	public PageBean<Payinfo> findPayinfo() {
		PageBean<Payinfo> bean =new PageBean<Payinfo>(); 
		List<Payinfo> list=shoesDao.findPayinfo();
		bean.setList(list);
		// TODO Auto-generated method stub
		return bean;
	}

	@Override
	public List<Confrom> findcontype() {
		List<Confrom> list=shoesDao.findcontype();
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public PageBean<Contype> findByPage(Integer currPage) {
		List<Contype> list=shoesDao.findall();
		PageBean<Contype> pageBean=new PageBean<Contype>();
		pageBean.setList(list);
		// TODO Auto-generated method stub
		return pageBean;
	}

	@Override
	public Contype findContyeById(Integer ctid) {
		
		// TODO Auto-generated method stub
		return shoesDao.findContypeById(ctid);
	}

	@Override
	public void delete(Contype contype) {
		// TODO Auto-generated method stub
		shoesDao.delete(contype);
	}

	@Override
	public void update(Contype contype) {
		// TODO Auto-generated method stub
		shoesDao.update(contype);
		
	}

	@Override
	public PageBean<Confrom> findallconfrom() {
		PageBean<Confrom> pageBean=new PageBean<Confrom>();
		List<Confrom> list=shoesDao.findallconfrom();
		pageBean.setList(list);
		// TODO Auto-generated method stub
		return pageBean;
	}

	@Override
	public void updateconfrom(Confrom confrom) {
		// TODO Auto-generated method stub
		shoesDao.updateconfrom(confrom);
	}

	@Override
	public Confrom findConfromById(Integer cfid) {
		// TODO Auto-generated method stub
		return shoesDao.findConfromById(cfid);
	}

	@Override
	public void deleteconfrom(Confrom confrom) {
		// TODO Auto-generated method stub
		shoesDao.deleteconfrom(confrom);
		
	}

	@Override
	public PageBean<Fundtype> findallfundtype() {
		PageBean<Fundtype> pageBean=new PageBean<Fundtype>();
		List<Fundtype> list=shoesDao.findallfundtype();
		pageBean.setList(list);
		// TODO Auto-generated method stub
		return pageBean;
	}

	@Override
	public void updatefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		shoesDao.updatefundtype(fundtype);
	}

	@Override
	public Fundtype findFundtypeById(Integer fid) {
		// TODO Auto-generated method stub
		
		return shoesDao.findFundtypeById(fid);
	}

	@Override
	public void deletefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		shoesDao.deletefundtype(fundtype);
	}

	@Override
	public void savefundtype(Fundtype fundtype) {
		// TODO Auto-generated method stub
		shoesDao.savefundtype(fundtype);
		
	}

	@Override
	public List<Confrom> findalllistconfrom() {
		// TODO Auto-generated method stub
		return shoesDao.findallconfrom();
	}

	@Override
	public List<Contype> findalllistContype() {
		// TODO Auto-generated method stub
		return shoesDao.findall();
	}

	@Override
	public List<Fundtype> findfundlist() {
		// TODO Auto-generated method stub
		return shoesDao.findallfundtype();
	}

	@Override
	public Payinfo findPayById(Integer pid) {
		// TODO Auto-generated method stub
		return shoesDao.findPayById(pid);
	}

	@Override
	public void deletepay(Payinfo payinfo) {
		// TODO Auto-generated method stub
		shoesDao.deletepay(payinfo);
	}

	@Override
	public List<Payinfo> findPayByCid(String str, Integer cno) {
		// TODO Auto-generated method stub
		return shoesDao.findPayByStr(str,cno);
	}

	@Override
	public PageBean<Paymode> findPayode() {
		// TODO Auto-generated method stub
		return shoesDao.findPaymode();
	}

	@Override
	public void savePaymode(Paymode paymode) {
		// TODO Auto-generated method stub
		shoesDao.findpaymode(paymode);
		
	}

	@Override
	public Paymode findPaymodeById(Integer pmid) {
		// TODO Auto-generated method stub
		return shoesDao.findPaymodeById(pmid);
	}

	@Override
	public void deletepaymode(Paymode paymode) {
		// TODO Auto-generated method stub
		shoesDao.deletepaymode(paymode);
	}

	@Override
	public List<Paymode> findPayModeByCid(Integer cid) {
		// TODO Auto-generated method stub
		return shoesDao.findPaymodeBycid(cid);
	}

	@Override
	public void  save(ShoesStatus shoesstatus) {
		// TODO Auto-generated method stub
		  shoesDao.save(shoesstatus);
	}

	@Override
	public List<ShoesStatus> find() {
		// TODO Auto-generated method stub
		return shoesDao.find();
	}

	@Override
	public List<Userinfo> finduser(String userName) {
		// TODO Auto-generated method stub
		return shoesDao.finduser(userName);
	}

	@Override
	public void adduser(Userinfo userinfo) {
		// TODO Auto-generated method stub
		 shoesDao.saveuser(userinfo);
	}

	@Override
	public List<ShoesStatus> findcurrent(ShoesStatus shoesstatus) {
		// TODO Auto-generated method stub
		return shoesDao.findcurrent(shoesstatus);
	}

	@Override
	public void updateshoesstatus(ShoesStatus shoesstatus) {
		// TODO Auto-generated method stub
		shoesDao.updateshoesstatus(shoesstatus);
	}

	@Override
	public void saveGpsinfo(Gpsinfo gpsinfo) {
		// TODO Auto-generated method stub
		shoesDao.saveGpsinfo(gpsinfo);
	}

	@Override
	public List<Gpsinfo> findcurrentgps(Integer sid, Date date) {
		// TODO Auto-generated method stub
		return shoesDao.findGpsinfo(sid,date);
	}

	

}
