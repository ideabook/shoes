package com.xxzx.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.annotations.Expose;

public class ShoesStatus {

	private Integer sid;
	@Expose
	private String userName;
	@Expose
	private Integer stepCounts;
	@Expose
	private Double longitude;
	@Expose
	private Double latitude;
	@Expose
	private Date stime;
	
	Set<Gpsinfo> gpsinfos=new HashSet<Gpsinfo>();
	
	public Set<Gpsinfo> getGpsinfos() {
		return gpsinfos;
	}
	public void setGpsinfos(Set<Gpsinfo> gpsinfos) {
		this.gpsinfos = gpsinfos;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getStepCounts() {
		return stepCounts;
	}
	public void setStepCounts(Integer stepCounts) {
		this.stepCounts = stepCounts;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	
	
	
	
	
	
}
