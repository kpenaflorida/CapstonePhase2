package com.example.Zumba.model;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Batch {

	private int Bid;
	private String batchName;
	private Date classTime;

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int bid, String batchName, Date classTime) {
		super();
		Bid = bid;
		this.batchName = batchName;
		this.classTime = classTime;
	}

	public int getBid() {
		return Bid;
	}

	public void setBid(int bid) {
		Bid = bid;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public Date getclassTime() {
		return classTime;
	}

	public void setclassTime(Date classTime) {
		this.classTime = classTime;
	}

	@Override
	public String toString() {
		return "Batch [Bid=" + Bid + ", batchName=" + batchName + ", classTime=" + classTime + "]";
	}

}
