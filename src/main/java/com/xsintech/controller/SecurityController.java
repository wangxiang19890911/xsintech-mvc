package com.xsintech.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.fabric.xmlrpc.base.Data;
import com.xsintech.model.Contract;
import com.xsintech.service.UserService;
import com.xsintech.util.DateUtils;

@Controller
public class SecurityController {
	@Resource
	private UserService userService;

//	@RequestMapping(value="/secure/login")
//	public String login() {
//		return "app/taxfree_contract";
//	}

	@RequestMapping(value="/secure/taxfree")
	public String texfree(String page,Model model){
		/*System.out.println(page);
		if(page==null){
		page="0";
		}
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("index", Integer.parseInt(page));
		map.put("index1", Integer.parseInt(page)+4);
		List<Contract> con =userService.findfAll(map);
		return con;*/
		return "app/taxfree_contract";
	}
	
//	@RequestMapping(value="/secure/labour")
//	public String labour() {
//		return "app/labour_contract";
//	}
	/**
	 * ∑÷“≥≤È—Ø
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/asd", method = RequestMethod.POST)
	@ResponseBody
	public  List<Contract> aaa(String pageNum,String pageSize){
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		List<Contract> con =null;
		System.out.println(pageNum);
		if("1".equals(pageNum)){
			
			map.put("index", Integer.parseInt(pageNum));
			map.put("index1", Integer.parseInt(pageSize));
			con =userService.findfAll(map);
			System.out.println(con.size());
			}else{
			
			map.put("index", (Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize)+1);
			map.put("index1", Integer.parseInt(pageNum)*Integer.parseInt(pageSize));
			con =userService.findfAll(map);
			}
			return con;
	}
	@RequestMapping(value="insert/into")
	public String insertin(){
		return "app/insert";
	}
	@RequestMapping(value="insert")
	public String insert(String name,String aparty,String bparty,String date){
		Contract c = new Contract();
		c.setName(name);
		c.setAparty(aparty);
		c.setBparty(bparty);
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-DD");
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		c.setDate(d);
		userService.insert(c);
		return "app/taxfree_contract";
	}
}
