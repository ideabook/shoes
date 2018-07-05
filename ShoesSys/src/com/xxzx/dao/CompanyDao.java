package com.xxzx.dao;

import java.util.List;

import com.xxzx.entity.Companyinfo;
import com.xxzx.entity.PageBean;

public interface CompanyDao {

	void save(Companyinfo companyinfo);

	List<Companyinfo> findAll();

	Companyinfo findById(int comid);

	void delete(Companyinfo companyinfo);

	void update(Companyinfo companyinfo);

}
