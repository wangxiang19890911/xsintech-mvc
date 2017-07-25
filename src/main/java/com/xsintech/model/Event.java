package com.xsintech.model;

import java.util.List;

public class Event {

	private Integer id;

	private String eventName;

	private String eventComment;

	private String userId;

	private Integer answerCount;

	private List<AnswerCountInfo> details;

	private String createdDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getEventComment() {
		return eventComment;
	}

	public void setEventComment(String eventComment) {
		this.eventComment = eventComment;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getAnswerCount() {
		return answerCount;
	}

	public void setAnswerCount(Integer answerCount) {
		this.answerCount = answerCount;
	}

	public List<AnswerCountInfo> getDetails() {
		return details;
	}

	public void setDetails(List<AnswerCountInfo> details) {
		this.details = details;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
