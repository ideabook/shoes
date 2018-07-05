package com.xxzx.entity;

import java.util.Date;

public class Gpsinfo {
	private Integer Gid;
	private Double longitude;
	private Double latitude ;
	private Date gdate;
	
	private ShoesStatus shoesStatus;

	public Integer getGid() {
		return Gid;
	}

	public void setGid(Integer gid) {
		Gid = gid;
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

	public Date getGdate() {
		return gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}

	public ShoesStatus getShoesStatus() {
		return shoesStatus;
	}

	public void setShoesStatus(ShoesStatus shoesStatus) {
		this.shoesStatus = shoesStatus;
	}
	
}
