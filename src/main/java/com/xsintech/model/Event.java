package com.xsintech.model;

import java.util.List;

public class Event {

	private Integer id;

	private String eventName;

	private String eventComment;

	private String userId;

	private Integer answers;

	private List<AnswerCountInfo> details;

	private String createdDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

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

	public Integer getAnswers() {
		return answers;
	}

	public void setAnswers(Integer answers) {
		this.answers = answers;
	}

	public List<AnswerCountInfo> getDetails() {
		return details;
	}

	public void setDetails(List<AnswerCountInfo> details) {
		this.details = details;
	}

}
