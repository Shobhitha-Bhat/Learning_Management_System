package com.LMS.Learning_Management_System.DTO;

import java.util.List;


public class CourseFacultyList {
	private int cId;
	private String cName;
	private List<InstructorResponseEntity> insts;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public List<InstructorResponseEntity> getInsts() {
		return insts;
	}
	public void setInsts(List<InstructorResponseEntity> insts) {
		this.insts = insts;
	}
	public CourseFacultyList(int cId, String cName, List<InstructorResponseEntity> insts) {
		super();
		this.cId = cId;
		this.cName = cName;
		this.insts = insts;
	}
	public CourseFacultyList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
