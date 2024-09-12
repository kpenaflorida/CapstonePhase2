package com.example.Zumba.model;

import java.util.Objects;

public class Participant {
	
	private int pid;
	private String name;
	private String phone;
	private String email;
	private int bid;
	
	
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Participant(int pid, String name, String phone, String email, int bid) {
		super();
		this.pid = pid;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.bid = bid;
	}




	@Override
	public int hashCode() {
		return Objects.hash(bid, email, name, phone, pid);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participant other = (Participant) obj;
		return bid == other.bid && Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && pid == other.pid;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	@Override
	public String toString() {
		return "Participant [pid=" + pid + ", name=" + name + ", phone=" + phone + ", email=" + email + ", bid=" + bid
				+ "]";
	}
	
	
	

}
