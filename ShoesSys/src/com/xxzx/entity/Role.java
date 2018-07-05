package com.xxzx.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 * @类名	Role.java
 * @作者	cola
 * @Emial	xyn.java@foxmail.com
 * @QQ	939313737
 * @日期 2016-9-6
 * @版本 V 1.0
 */
public class Role {

	private int id;// 主键ID
	private String name;// 角色名称
	private String value;// 角色值
	private Set<Userinfo> users = new HashSet<Userinfo>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<Userinfo> getUsers() {
		return users;
	}
	public void setUsers(Set<Userinfo> users) {
		this.users = users;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}