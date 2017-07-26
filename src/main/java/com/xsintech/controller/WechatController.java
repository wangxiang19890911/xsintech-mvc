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
import com.xsintech.util.CONST;
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
		final String urlString = "https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code&appid=" + CONST.APP_ID + "&secret=" + CONST.SECRET + "&js_code="
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
//					openid = UUID.randomUUID().toString();
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
		Event event = this.wechatService.getEventById(id);
		if (null != event) {
			List<AnswerCountInfo> events = this.wechatService.getAnswerCountInfoByEventId(id);
			event.setDetails(events);

			Integer answerCount = this.wechatService.getAnswerCountByEventId(id);
			event.setAnswerCount(answerCount);
		}

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
		List<Event> myEvents = this.wechatService.getUserEventListByUserId(userId);

		return myEvents;
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
		List<AnswerInfo> subDetails = this.wechatService.getSubDetail(id, subId);
		return subDetails;
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
		Integer eventId = this.wechatService.save(name, datas, comment, userId);

		return eventId;
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
	public String create(Integer id) throws URISyntaxException {
		final String urlString = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + CONST.APP_ID + "&secret=" + CONST.SECRET;
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

				filePath = this.createQRCode(token, id);
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
	private String createQRCode(String token, Integer id) throws ClientProtocolException, IOException {
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
			obj.element("path", "pages/detail/detail?id=" + id);

			out.writeBytes(obj.toString());
			out.flush();
			out.close();

			filePath = CONST.FILE_PATH;
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
