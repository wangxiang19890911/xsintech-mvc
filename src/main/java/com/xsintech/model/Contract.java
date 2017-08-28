package com.xsintech.model;

import java.util.Date;


public class Contract {
	private String Name;
	private String Aparty;
	private String Bparty;
	private Date Data;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAparty() {
		return Aparty;
	}
	public void setAparty(String aparty) {
		Aparty = aparty;
	}
	public String getBparty() {
		return Bparty;
	}
	public void setBparty(String bparty) {
		Bparty = bparty;
	}
	public Date getDate() {
		return Data;
	}
	public void setDate(Date date) {
		this.Data = date;
	}
}
