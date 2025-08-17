package com.LMS.Learning_Management_System.Exceptions;

import java.time.LocalDateTime;

public class ErrorResponseEntity {
	private LocalDateTime timestamp;
	private int status;
	private String msg;
	private String details;
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorResponseEntity(LocalDateTime timestamp, int status, String msg, String details) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.msg = msg;
		this.details = details;
	}
	public ErrorResponseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
