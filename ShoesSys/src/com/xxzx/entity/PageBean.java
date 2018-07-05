package com.xxzx.entity;

import java.util.List;

/**
 * 
 * @author 一
 *
 */

public class PageBean<T> {
	private int currPage;//当前页
	private int pageSize;
	private int totalCount;
	private int totalPage;
	private double paycount;
	private List<T> list;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public double getPaycount() {
		return paycount;
	}
	public void setPaycount(double paycount) {
		this.paycount = paycount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
