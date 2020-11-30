package com.gjun.domain;

public class GjunCustomers {
	private short customer_id;
	private String first_name;
	private String last_name;
	private String email;
	private byte active;
	private byte store_id;
	private String create_date;
	public short getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(short customer_id) {
		this.customer_id = customer_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte getActive() {
		return active;
	}
	public void setActive(byte active) {
		this.active = active;
	}
	public byte getStore_id() {
		return store_id;
	}
	public void setStore_id(byte store_id) {
		this.store_id = store_id;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	
}
