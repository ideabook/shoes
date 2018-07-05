package com.xxzx.dao;

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

public interface ShoesDao {

	void save(ShoesStatus shoesStatus);

	void saveconfrom(Confrom confrom);

	void savePayinfo(Payinfo payinfo);

	List<Payinfo> findPayinfo();

	List<Confrom> findcontype();

	List<Contype> findall();

	void delete(Contype contype);

	Contype findContypeById(Integer ctid);

	void update(Contype contype);

	void deleteconfrom(Confrom confrom);

	Confrom findConfromById(Integer cfid);

	void updateconfrom(Confrom confrom);

	List<Confrom> findallconfrom();

	void savefundtype(Fundtype fundtype);

	void deletefundtype(Fundtype fundtype);
	
	void updatefundtype(Fundtype fundtype);

	Fundtype findFundtypeById(Integer fid);

	List<Fundtype> findallfundtype();

	Payinfo findPayById(Integer pid);

	void deletepay(Payinfo payinfo);

	List<Payinfo> findPayByStr(String str, Integer cno);

	PageBean<Paymode> findPaymode();

	void findpaymode(Paymode paymode);

	Paymode findPaymodeById(Integer pmid);

	void deletepaymode(Paymode paymode);

	List<Paymode> findPaymodeBycid(Integer cid);

	List<ShoesStatus> find();

	List<Userinfo> finduser(String userName);

	void saveuser(Userinfo userinfo);

	List<ShoesStatus> findcurrent(ShoesStatus shoesstatus);

	void updateshoesstatus(ShoesStatus shoesstatus);

	void saveGpsinfo(Gpsinfo gpsinfo);

	

	List<Gpsinfo> findGpsinfo(Integer sid, Date date);



}
