package com.xsintech.model;

import java.util.List;

public class AnswerVO {

	private Integer id;

	private String userId;

	private String answerName;

	private String answerComment;

	private List<EventDetail> details;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public String getAnswerComment() {
		return answerComment;
	}

	public void setAnswerComment(String answerComment) {
		this.answerComment = answerComment;
	}

	public List<EventDetail> getDetails() {
		return details;
	}

	public void setDetails(List<EventDetail> details) {
		this.details = details;
	}

}
