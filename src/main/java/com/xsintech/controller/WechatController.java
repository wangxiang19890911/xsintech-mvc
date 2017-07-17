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
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.xsintech.util.DateUtils;

@Controller
public class WechatController {

	@RequestMapping(value = "/wechat/save", method = RequestMethod.POST)
	@ResponseBody
	public void login(String name, String dates, String comment) {
		System.out.println(dates);
		System.out.println(name);
		System.out.println(comment);
	}

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

	@RequestMapping(value = "/wechat/getQRCode")
	@ResponseBody
	public void get(String filePath, HttpServletResponse response) {
		try {
			File file = new File(filePath);
            InputStream fis = new BufferedInputStream(new FileInputStream(filePath));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
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

	private String createQRCode(String token) throws ClientProtocolException, IOException {
		final String urlString = "https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + token;
		String filePath = "";
		String fileName = "";
		
		try {
			// 创建连接
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestMethod("POST");
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			connection.connect();

			// POST请求
			DataOutputStream out = new DataOutputStream(connection.getOutputStream());
			net.sf.json.JSONObject obj = new net.sf.json.JSONObject();
			obj.element("path", "pages/detail/detail");

			out.writeBytes(obj.toString());
			out.flush();
			out.close();

			// 转换文件
			filePath = "/Users/pactera/Documents/develop/xsintech/qrcode/";
			fileName = "qrcode"+DateUtils.YYYYMMDDHHMMSS.get().format(new Date()).toString()+".jpeg";
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

			// 断开连接
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
