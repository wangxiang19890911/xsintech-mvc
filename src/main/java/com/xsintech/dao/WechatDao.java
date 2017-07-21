package com.xsintech.dao;

import java.util.List;

import com.xsintech.model.AnswerCountInfo;
import com.xsintech.model.AnswerDetailInfo;
import com.xsintech.model.AnswerInfo;
import com.xsintech.model.Event;
import com.xsintech.model.EventOption;

public interface WechatDao {

	List<AnswerCountInfo> getAnswerCountInfoByEventId(Integer id);

	List<Event> getUserEventListByUserId(String userId);

	List<EventOption> getSubDetail(Integer id, Integer subId, Integer status);

	Integer saveEvent(Event event);

	Integer saveEventOption(Integer eventId, String option);

	Integer saveAnswerInfo(AnswerInfo answerInfo);

	Integer saveAnswerDetailInfo(Integer answerId, AnswerDetailInfo detailInfo);
}
