package com.xxzx.entity;

import java.util.Date;

public class Fileinfo {
	private Integer fileid;
	private String filepath;
	private String filename;//文件名
	private String filetype;//文件类型
	private String filemore;
	private Date fileuptime;
	
	public Integer getFileid() {
		return fileid;
	}
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getFilemore() {
		return filemore;
	}
	public void setFilemore(String filemore) {
		this.filemore = filemore;
	}

	public Date getFileuptime() {
		return fileuptime;
	}
	public void setFileuptime(Date fileuptime) {
		this.fileuptime = fileuptime;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	
	
}
