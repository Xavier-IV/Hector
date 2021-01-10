package com.hector.model;

public class Shop {
	private String registrationCode;
	private String name;
	private String phoneNum;
	private ShopStatus status;
	private String manager;

	public enum ShopStatus {
		CLEAR,
		CASE,
		CONTACT
	}

	public Shop(
			String registrationCode,
			String name,
			String phoneNum,
			ShopStatus status,
			String manager){
		this.registrationCode = registrationCode;
		this.name = name;
		this.phoneNum = phoneNum;
		this.status = status;
		this.manager = manager;
	}
	
	public String getShopname(){
		return name;
	}
	
	public String getShopphone(){
		return phoneNum;
	}
	
	public ShopStatus getShopstatus(){
		return status;
	}
	
	public String getManager(){
		return manager;
	}
	
	public void setShopname(String name){
		this.name = name;
	}
	
	public void setShopphone(String phoneNum){
		this.phoneNum = phoneNum;
	}
	
	public void setShopstatus(ShopStatus status){
		this.status = status;
	}
	
	public void setManager(){
		this.manager = manager;
	}
}
