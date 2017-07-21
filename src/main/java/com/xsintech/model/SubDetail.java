package com.xsintech.model;

public class SubDetail {

	private Long subId;

	private String userId;

	private String userName;

	private Integer status;

	private String answeredDate;

	private String comment;

	
	public Long getSubId() {
		return subId;
	}

	public void setSubId(Long subId) {
		this.subId = subId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAnsweredDate() {
		return answeredDate;
	}

	public void setAnsweredDate(String answeredDate) {
		this.answeredDate = answeredDate;
	}

}
