package com.xsintech.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xsintech.model.AnswerCountInfo;
import com.xsintech.model.AnswerDetailInfo;
import com.xsintech.model.AnswerInfo;
import com.xsintech.model.Event;
import com.xsintech.service.WechatService;
import com.xsintech.util.DateUtils;
import com.xsintech.util.PasswordUtil;

import net.sf.json.JSONArray;

@Controller
public class WechatController {

	@Autowired
	private WechatService wechatService;

	/**
	 * login
	 * 
	 * @param code
	 */
	@RequestMapping(value = "/wechat/login", method = RequestMethod.GET)
	@ResponseBody
	public String login(String code) {
		final String urlString = "https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code&appid=wx54cdbffbb1eef645&secret=b4c5b7d38063c7c73d9e37ca3d06c047&secret=b4c5b7d38063c7c73d9e37ca3d06c047&js_code="
				+ code;
		HttpURLConnection con = null;
		BufferedReader br = null;
		StringBuffer jsonBuffer = null;
		String openid = "";

		try {
			try {
				URL url = new URL(urlString);
				con = (HttpURLConnection) url.openConnection();
				con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				con.connect();
				jsonBuffer = new StringBuffer();
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String temp;
				while ((temp = br.readLine()) != null) {
					jsonBuffer.append(temp);
				}

				Map<String, Object> map = JSONObject.parseObject(jsonBuffer.toString());
				System.out.println("openid = " + String.valueOf(map.get("openid")));
				if (null != map.get("openid")) {
					openid = PasswordUtil.sha256hash(map.get("openid").toString().getBytes("Windows-31J"), "xsintech",
							1000);
					System.out.println("new openid = " + openid);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						br = null;
						throw new RuntimeException(e);
					} finally {
						if (con != null) {
							con.disconnect();
							con = null;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return openid;
	}

	/**
	 * get event
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/wechat/detail", method = RequestMethod.GET)
	@ResponseBody
	public Event getDetail(Integer id) {
//		List<EventAnswerInfo> events = this.wechatService.getAnswerCountInfoByEventId(id);

		// TODO test data
		Event event = new Event();
		List<AnswerCountInfo> events = new ArrayList<AnswerCountInfo>();

		AnswerCountInfo e = new AnswerCountInfo();
		e.setSubId(101);
		e.setDate("2017/07/07(五) 19:00 ~ 22:30");
		e.setAttend(3);
		e.setUndetermined(2);
		e.setCancel(2);
		e.setStatus(1);
		events.add(e);

		e = new AnswerCountInfo();
		e.setSubId(102);
		e.setDate("2017/07/08(六) 17:00 ~ 20:00");
		e.setAttend(4);
		e.setUndetermined(1);
		e.setCancel(2);
		e.setStatus(0);
		events.add(e);

		e = new AnswerCountInfo();
		e.setSubId(103);
		e.setDate("2017/07/09(日) 17:00 ~ 20:00");
		e.setAttend(5);
		e.setUndetermined(1);
		e.setCancel(1);
		e.setStatus(2);
		events.add(e);

		e = new AnswerCountInfo();
		e.setSubId(104);
		e.setDate("2017/07/10(一) 17:00 ~ 20:00");
		e.setAttend(5);
		e.setUndetermined(1);
		e.setCancel(1);
		e.setStatus(2);
		events.add(e);

		event.setId(11100);
		event.setEventName("聚会吧小伙伴们！");
		event.setEventComment("吃饭唱歌喝酒吧！去哪？");
		event.setAnswers(7);
		event.setDetails(events);

		return event;
	}

	/**
	 * login
	 * 
	 * @param code
	 */
	@RequestMapping(value = "/wechat/self", method = RequestMethod.GET)
	@ResponseBody
	public List<Event> myEvent(String userId) {
//		List<Event> myEvents = this.wechatService.getUserEventListByUserId(userId);
		
		List<Event> list = new ArrayList<Event>();

		// TODO test data
		Event event = new Event();
		event.setId(10010);
		event.setEventName("今天周五了大家去聚会吧1");
		event.setAnswers(8);
		event.setCreatedDate("2017/07/01 15:30:15");
		list.add(event);

		event = new Event();
		event.setId(10011);
		event.setEventName("今天周五了大家去聚会吧2");
		event.setAnswers(11);
		event.setCreatedDate("2017/07/01 15:30:15");
		list.add(event);

		event = new Event();
		event.setId(10012);
		event.setEventName("今天周五了大家去聚会吧3今天周五了大家去聚会吧3今天周五了大家去聚会吧");
		event.setAnswers(3);
		event.setCreatedDate("2017/07/01 15:30:15");
		list.add(event);

		return list;
	}

	/**
	 * get event
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/wechat/sub_detail", method = RequestMethod.GET)
	@ResponseBody
	public List<AnswerInfo> getSubDetail(Integer id, Integer subId) {
//		List<SubDetail> subDetails = this.wechatService.getSubDetail(id, subId, status);

		// TODO test data
		List<AnswerInfo> answerInfos = new ArrayList<AnswerInfo>();
		AnswerInfo answerInfo = new AnswerInfo();
		answerInfo.setAnswerName("小李1");
		answerInfo.setAnswerComment("xxxxxxxxxxxxxxxxxxxxxxxxxx");
		answerInfo.setAnswerDate("2017/07/01 11:11:11");
		answerInfo.setStatus(1);
		answerInfos.add(answerInfo);
		
		answerInfo = new AnswerInfo();
		answerInfo.setAnswerName("小李2");
		answerInfo.setAnswerComment("xxxxxxxxxxxxxxxxxxxxxxxxxx");
		answerInfo.setAnswerDate("2017/07/01 11:11:11");
		answerInfo.setStatus(1);
		answerInfos.add(answerInfo);
		
		answerInfo = new AnswerInfo();
		answerInfo.setAnswerName("小李3");
		answerInfo.setAnswerComment("xxxxxxxxxxxxxxxxxxxxxxxxxx");
		answerInfo.setAnswerDate("2017/07/01 11:11:11");
		answerInfo.setStatus(1);
		answerInfos.add(answerInfo);
		
		return answerInfos;
	}

	/**
	 * save
	 * 
	 * @param name
	 * @param dates
	 * @param comment
	 */
	@RequestMapping(value = "/wechat/save", method = RequestMethod.POST)
	@ResponseBody
	public Integer saveEvent(String name, String datas, String comment, String userId) {
//		Integer eventId = this.wechatService.save(name, datas, comment, userId);

		// TODO return id
		return 10010;
	}

	/**
	 * answer
	 * 
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/wechat/answer", method = RequestMethod.POST)
	@ResponseBody
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean answer(String json) {
		Map<String, Object> map = (Map<String, Object>) JSONObject.parse(json);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		for (Object obj : map.entrySet()) {
			if ("details".equals(((Map.Entry) obj).getKey())) {
				JSONArray jsonArray = JSONArray.fromObject(((Map.Entry) obj).getValue().toString());
				List<AnswerDetailInfo> details = (List<AnswerDetailInfo>) JSONArray.toCollection(jsonArray, AnswerDetailInfo.class);
				paramMap.put("details", details);
			} else {
				paramMap.put(((Map.Entry) obj).getKey().toString(), ((Map.Entry) obj).getValue().toString());
			}
		}

		this.wechatService.answer(paramMap);
		return true;
	}

	/**
	 * create qr code
	 * 
	 * @return
	 * @throws URISyntaxException
	 */
	@RequestMapping(value = "/wechat/createQRCode")
	@ResponseBody
	public String create() throws URISyntaxException {
		final String urlString = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx54cdbffbb1eef645&secret=b4c5b7d38063c7c73d9e37ca3d06c047";
		String filePath = "";
		HttpURLConnection con = null;
		BufferedReader br = null;
		StringBuffer jsonBuffer = null;

		try {
			try {
				URL url = new URL(urlString);
				con = (HttpURLConnection) url.openConnection();
				con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				con.connect();
				jsonBuffer = new StringBuffer();
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
				String temp;
				while ((temp = br.readLine()) != null) {
					jsonBuffer.append(temp);
				}

				Map<String, Object> map = JSONObject.parseObject(jsonBuffer.toString());
				String token = map.get("access_token").toString();

				filePath = this.createQRCode(token);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						br = null;
						throw new RuntimeException(e);
					} finally {
						if (con != null) {
							con.disconnect();
							con = null;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return filePath;
	}

	/**
	 * get qr code
	 * 
	 * @param filePath
	 * @param response
	 */
	@RequestMapping(value = "/wechat/getQRCode")
	@ResponseBody
	public void get(String filePath, HttpServletResponse response) {
		try {
			File file = new File(filePath);
			InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
			byte[] buffer = new byte[fis.available()];
			fis.read(buffer);
			fis.close();
			response.reset();
			response.addHeader("Content-Disposition", "attachment;filename=" + new String(file.getName().getBytes()));
			response.addHeader("Content-Length", "" + file.length());
			OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
			response.setContentType("application/octet-stream");
			toClient.write(buffer);
			toClient.flush();
			toClient.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * create local qr code
	 * 
	 * @param token
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private String createQRCode(String token) throws ClientProtocolException, IOException {
		final String urlString = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + token;
		String filePath = "";
		String fileName = "";

		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			connection.connect();

			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
			obj.element("path", "pages/detail/detail");

			out.writeBytes(obj.toString());
			out.flush();
			out.close();

			// TODO path?
			filePath = "/Users/pactera/Documents/develop/xsintech/qrcode/";
			fileName = "qrcode" + DateUtils.YYYYMMDDHHMMSS.get().format(new Date()).toString() + ".jpeg";
			File file = new File(filePath, fileName);
			InputStream in = connection.getInputStream();
			OutputStream os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
			os.close();
			in.close();

			connection.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return filePath + fileName;
	}
}