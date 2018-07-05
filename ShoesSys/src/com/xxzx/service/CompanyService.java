package com.xxzx.service;

import java.util.List;

import com.xxzx.entity.Companyinfo;
import com.xxzx.entity.PageBean;

public interface CompanyService {

	void save(Companyinfo companyinfo);

	PageBean<Companyinfo> findAll();

	List<Companyinfo> findalllist();

	Companyinfo findById(int comid);

	void update(Companyinfo companyinfo);

	void delete(Companyinfo companyinfo);

}
