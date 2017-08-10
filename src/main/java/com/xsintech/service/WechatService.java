package com.xsintech.service;

import java.util.List;
import java.util.Map;

import com.xsintech.model.AnswerCountInfo;
import com.xsintech.model.AnswerDetailInfo;
import com.xsintech.model.AnswerInfo;
import com.xsintech.model.Event;

public interface WechatService {

	List<AnswerCountInfo> getAnswerCountInfoByEventId(Integer id);

	List<Event> getUserEventListByUserId(String userId);

	List<AnswerInfo> getSubDetail(Integer id, Integer subId);

	Integer save(String name, String datas, String comment, String userId);

	Integer saveEventOptions(Integer eventId, String[] options);

	Integer saveAnswerDetailInfo(Integer answerId, List<AnswerDetailInfo> detailInfos);

	Integer getAnswerCountByEventId(Integer answerId);

	boolean answer(Map<String, Object> paramMap);

	Event getEventById(Integer id);

	Integer saveFileName(Integer id, String fileName);
}
