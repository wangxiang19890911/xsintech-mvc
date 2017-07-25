package com.xsintech.dao;

import java.util.List;

import com.xsintech.model.AnswerCountInfo;
import com.xsintech.model.AnswerDetailInfo;
import com.xsintech.model.AnswerInfo;
import com.xsintech.model.Event;

public interface WechatDao {

	List<AnswerCountInfo> getAnswerCountInfoByEventId(Integer id);

	List<Event> getUserEventListByUserId(String userId);

	List<AnswerInfo> getSubDetail(Integer id, Integer subId);

	Integer saveEvent(Event event);

	Integer saveEventOption(Integer eventId, String option);

	Integer saveAnswerInfo(AnswerInfo answerInfo);

	Integer saveAnswerDetailInfo(Integer answerId, AnswerDetailInfo detailInfo);

	Integer getAnswerCountByEventId(Integer answerId);

	Event getEventById(Integer id);
}
