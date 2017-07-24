package com.xsintech.service;

import java.util.List;
import java.util.Map;

import com.xsintech.model.AnswerCountInfo;
import com.xsintech.model.AnswerDetailInfo;
import com.xsintech.model.Event;
import com.xsintech.model.EventOption;
public interface WechatService {

	List<AnswerCountInfo> getAnswerCountInfoByEventId(Integer id);

	List<Event> getUserEventListByUserId(String userId);

	List<EventOption> getSubDetail(Integer id, Integer subId, Integer status);

	Integer save(String name, String datas, String comment, String userId);

	Integer saveEventOptions(Integer eventId, String[] options);

	Integer saveAnswerDetailInfo(Integer answerId, List<AnswerDetailInfo> detailInfos);

	boolean answer(Map<String, Object> paramMap);
}
