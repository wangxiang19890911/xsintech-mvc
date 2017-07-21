package com.xsintech.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.xsintech.dao.WechatDao;
import com.xsintech.model.AnswerCountInfo;
import com.xsintech.model.AnswerDetailInfo;
import com.xsintech.model.AnswerInfo;
import com.xsintech.model.Event;
import com.xsintech.model.EventOption;
import com.xsintech.service.WechatService;

public class WechatServiceImpl implements WechatService {

	@Autowired
	private WechatDao wechatDao;

	public List<AnswerCountInfo> getAnswerCountInfoByEventId(Integer id) {
		return this.wechatDao.getAnswerCountInfoByEventId(id);
	}

	public List<Event> getUserEventListByUserId(String userId) {
		return this.wechatDao.getUserEventListByUserId(userId);
	}

	public List<EventOption> getSubDetail(Integer id, Integer subId, Integer status) {
		return getSubDetail(id, subId, status);
	}

	public Integer save(String name, String datas, String comment, String userId) {
		Event saveEvent = new Event();
		saveEvent.setEventName(name);
		saveEvent.setEventComment(comment);
		saveEvent.setUserId(userId);
		if (this.wechatDao.saveEvent(saveEvent) == 1) {
			String[] dataArray = datas.split("\n");
			this.saveEventOptions(saveEvent.getId(), dataArray);
		}
		
		return saveEvent.getId();
	}

	public boolean answer(Map<String, Object> paramMap) {
		Integer id = Integer.parseInt(paramMap.get("id").toString());
		String userId = paramMap.get("userId").toString();
		String answerName = paramMap.get("answerName").toString();
		String answerComment = paramMap.get("answerComment").toString();
		List<AnswerDetailInfo> details = (List<AnswerDetailInfo>)paramMap.get("details");

		AnswerInfo answerInfo = new AnswerInfo();
		answerInfo.setEventId(id);
		answerInfo.setUserId(userId);
		answerInfo.setAnswerName(answerName);
		answerInfo.setAnswerComment(answerComment);
		
		if (this.wechatDao.saveAnswerInfo(answerInfo) == 1) {
			this.saveAnswerDetailInfo(answerInfo.getAnswerId(), details);
		}
		return false;
	}

	public Integer saveEventOptions(Integer eventId, String[] options) {
		int row = 0;
		for (String option : options) {
			row += this.wechatDao.saveEventOption(eventId, option);
		}
		return row;
	}

	public Integer saveAnswerDetailInfo(Integer answerId, List<AnswerDetailInfo> detailInfos) {
		int row = 0;
		for (AnswerDetailInfo answerDetailInfo : detailInfos) {
			row += this.wechatDao.saveAnswerDetailInfo(answerId, answerDetailInfo);
		}
		return row;
	}

}
