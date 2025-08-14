package com.LMS.Learning_Management_System.DTO;

public class UpdateEnrollment {
	private String stUsn;
	private int cId;
	private int marks;
	public String getStUsn() {
		return stUsn;
	}
	public void setStUsn(String stUsn) {
		this.stUsn = stUsn;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "UpdateEnrollment [stUsn=" + stUsn + ", cId=" + cId + ", marks=" + marks + "]";
	}
	public UpdateEnrollment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateEnrollment(String stUsn, int cId, int marks) {
		super();
		this.stUsn = stUsn;
		this.cId = cId;
		this.marks = marks;
	}
	
	
	
}
