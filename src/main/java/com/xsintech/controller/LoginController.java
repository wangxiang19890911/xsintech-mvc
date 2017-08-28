package com.xsintech.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsintech.model.User;
import com.xsintech.model.ValidationResult;
import com.xsintech.service.UserService;
import com.xsintech.util.MailUtil;

@Controller
public class LoginController {

	@Resource
	private UserService userService;

	// TODO ȫƪ������������
	/**
	 * ��ҳ������¼ҳ��
	 * 
	 * @param res
	 * @param req
	 * @param model
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/login")
	public String login(HttpServletResponse res, HttpServletRequest req,Model model) throws ServletException, IOException{
		 Cookie[] cs = req.getCookies();
		 // TODO ͨ�������nameȡ��value
		 if(cs!=null){
			 for(Cookie c :cs){
				 if("default_userId".equals(c.getName())){
					 model.addAttribute("default_userId", c.getValue());	
				 }
			 }
			 // �ӻ�����ȡ����û����� set��loginҳ����
			 // model���ص�ǰ̨ model.addAttribute("default_userId", "testUser");
		 }
		return "login";
	}
	/**
	 * ��¼��֤
	 * 
	 * @param userName
	 * @param passWord
	 * @param flag
	 * @param model
	 * @param res
	 * @return ��¼��֤���
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public String getUser(String userName, String passWord, String flag, Model model, HttpServletResponse res,String page,HttpSession session) {
		
		User user = new User();
		try{
			user = userService.checkLogin(userName, passWord);
			if (user.getState()!=null) {
				// if flag.eq("1")   ���û������ڻ�����
				if("1".equals(flag)){	
					Cookie cookie = new Cookie("default_userId",userName);
					 cookie.setMaxAge(60*60*24);
					 res.addCookie(cookie);
				}
				
				if("z".equals(user.getState())){
					System.out.println(user.getState());
					List<User>list = userService.findName(userName);
					System.out.println(list.size());
					User str = list.get(0);
					String str1 = str.getName()+str.getName1();
					session.setAttribute("default_userId1", str1);
					if(page==null){
					page="1";
					}
					return "app/taxfree_contract";
				}else{
					model.addAttribute("default_userId1", userName);
					return "app/password_reset";
				}
			}
			}catch(Exception e){
				//e.printStackTrace();
				model.addAttribute("error", "�û������������!");
			}
		
		return "login";
	}
	
	/**
	 * �״ε�¼��Ҫ�޸�����
	 * @param username
	 * @param password
	 * @param session
	 * @param model
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/updat")
	public String up(String username,String password,HttpSession session,Model model,HttpServletRequest req){
		User u = new User();
		System.out.println(username);
		try{
			u.setPassWord(password);
			u.setUserName(username);
			userService.up(u);
			System.out.println(u.getUserName());
			System.out.println(u.getPassWord());
		}catch(Exception e){
			return "error";
		}
		return"app/login_jump";
	}

	/**
	 * ע��
	 * @param userName
	 * @param gender
	 * @param old
	 * @param photo
	 * @param email
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/save")
	public String save(String userName,String gender,int old,String photo,String email,String name,String name1) throws ServletException, IOException {
	// TODO ������Ҫ��request���ȡ�ã� ֱ��ͨ����������ӳ��
		System.out.println("save");
		User u = new User();
	        //�ռ�����Ϣ
		System.out.println(email+":"+old);
	        String receiveMailAccount= email;
	        MailUtil mr=new MailUtil();
	        String title="�Ŵ�������ͬ�����ע��";
	        String to =null;
	        String from = null;
	        try {
	               System.out.println(mr.SendMail(receiveMailAccount,from,to,title));
	               String password = MailUtil.RandomCode;
	               u.setUserName(userName);
	               u.setName(name);
	               u.setName1(name1);
	               u.setPassWord(password);
	               u.setGender(gender);
	               u.setOld(old);
	               u.setPhoto(photo);
	               u.setEmail(email);
	               userService.save(u);
	        } catch (Exception e) {
	        	return "error";
	        }
				return"app/save_login";
	}
		
	@RequestMapping(value = "/doSave")
	public String doSave(){
		return"app/save_user";
	}
	/**
	 * ajax ��ѯ�˺�
	 * @param req
	 * @param res
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "/saveOne")
	@ResponseBody
	public ValidationResult saveOne(String userName) throws ServletException, IOException{
		User u = new User();
		u.setUserName(userName);
		System.out.println(u.getUserName());
		int c = userService.findOne(u.getUserName());
		ValidationResult result = new ValidationResult();
		if (1 == c) {
			result.setResult(false);
			result.setMessage("�û�����ռ��");
		}else{
			result.setResult(true);
			result.setMessage("����ʹ��");
		}
		return result;
	}
	
	/**
	 * �˳���¼
	 */
	@RequestMapping(value = "/signOut")
	public String signOut(HttpSession session){
		session.removeAttribute("default_userId1");
		return "login";
	}
	
}

