package com.xxzx.service;

import java.util.Date;
import java.util.List;

import com.xxzx.entity.Confrom;
import com.xxzx.entity.Contype;
import com.xxzx.entity.Fundtype;
import com.xxzx.entity.Gpsinfo;
import com.xxzx.entity.PageBean;
import com.xxzx.entity.Payinfo;
import com.xxzx.entity.Paymode;
import com.xxzx.entity.ShoesStatus;
import com.xxzx.entity.Userinfo;

public interface ShoesService {

	void save(ShoesStatus shoesstatus);

	void saveconfrom(Confrom confrom);

	void savePayinfo(Payinfo payinfo);

	PageBean<Payinfo> findPayinfo();

	List<Confrom> findcontype();

	PageBean<Contype> findByPage(Integer currPage);

	Contype findContyeById(Integer ctid);

	void delete(Contype contype);

	void update(Contype contype);

	PageBean<Confrom> findallconfrom();

	void updateconfrom(Confrom confrom);

	Confrom findConfromById(Integer cfid);

	void deleteconfrom(Confrom confrom);

	PageBean<Fundtype> findallfundtype();

	void updatefundtype(Fundtype fundtype);

	Fundtype findFundtypeById(Integer fid);

	void deletefundtype(Fundtype fundtype);

	void savefundtype(Fundtype fundtype);

	List<Confrom> findalllistconfrom();

	List<Contype> findalllistContype();

	List<Fundtype> findfundlist();

	Payinfo findPayById(Integer pid);

	void deletepay(Payinfo payinfo);

	List<Payinfo> findPayByCid(String str, Integer integer);

	PageBean<Paymode> findPayode();

	void savePaymode(Paymode paymode);

	Paymode findPaymodeById(Integer pmid);

	void deletepaymode(Paymode paymode);

	List<Paymode> findPayModeByCid(Integer cid);

	List<ShoesStatus> find();

	List<Userinfo> finduser(String userName);

	void adduser(Userinfo userinfo);

	List<ShoesStatus> findcurrent(ShoesStatus shoesstatus);

	void updateshoesstatus(ShoesStatus shoesstatus);

	void saveGpsinfo(Gpsinfo gpsinfo);

	List<Gpsinfo> findcurrentgps(Integer sid, Date date);



}
