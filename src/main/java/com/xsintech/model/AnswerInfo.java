package com.xsintech.model;

import java.util.List;

public class AnswerInfo {

	private Integer answerId;

	private Integer eventId;

	private String userId;

	private String answerName;

	private String answerComment;

	private String answerDate;

	private Integer status;

	private List<AnswerDetailInfo> answerDetails;

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getAnswerDate() {
		return answerDate;
	}

	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}

	public List<AnswerDetailInfo> getAnswerDetails() {
		return answerDetails;
	}

	public void setAnswerDetails(List<AnswerDetailInfo> answerDetails) {
		this.answerDetails = answerDetails;
	}

	public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
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

}
