package com.xsintech.controller;

import java.util.Date;
import java.io.IOException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xsintech.model.Contract;
import com.xsintech.model.ValidationResult;
import com.xsintech.service.TaxfreeContractService;
import com.xsintech.service.UserService;


@Controller
public class TaxfreeContractController {
	
	@Resource
	private TaxfreeContractService taxfreeContractService;
	
	/**
	 * ��ҳ��ѯ
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value = "/judge", method = RequestMethod.POST)
	@ResponseBody
	public  List<Contract> aaa(String pageNum,String pageSize,String entryName,String AParty,String BParty){
		HashMap<String,Object> map = new HashMap<String,Object>();
		List<Contract> con =null;
		String s = "";
		if(""==entryName){
			entryName=null;
		}
		if(""==AParty){
			AParty=null;
		}
		if(""==BParty){
			BParty=null;
		}
		if("1".equals(pageNum)){
			
			map.put("index", Integer.parseInt(pageNum));
			map.put("index1", Integer.parseInt(pageSize));
			map.put("str", entryName);
			map.put("str1", AParty);
			map.put("str2", BParty);
			System.out.println(map);
			con =taxfreeContractService.findfAll(map);
			System.out.println(con.size());
			}else{
			
			map.put("index", (Integer.parseInt(pageNum)-1)*Integer.parseInt(pageSize)+1);
			map.put("index1", Integer.parseInt(pageNum)*Integer.parseInt(pageSize));
			map.put("str", entryName);
			map.put("str1",AParty);
			map.put("str2", BParty);
			con =taxfreeContractService.findfAll(map);
			}
			return con;
	}
	
	/**
	 * �½���ͬ
	 * @param name
	 * @param aparty
	 * @param bparty
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="insert")
	public String insert(String name,String aparty,String bparty,String date) throws ParseException{
		Contract c = new Contract();
		c.setName(name);
		c.setAparty(aparty);
		c.setBparty(bparty);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = null;
		d = (Date) sdf.parse(date);
		System.out.println(d);
		c.setDate(d);
		taxfreeContractService.inser(c);
		return "app/taxfree_contract";
	}
	
	/**
	 * ajax����ͬ�Ƿ�ռ��
	 * @param name
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "insert/contract")
	@ResponseBody
	public ValidationResult contract(String name) throws ServletException, IOException{
		Contract u = new Contract();
		u.setName(name);
		int c = taxfreeContractService.NewContract(u.getName());
		ValidationResult result = new ValidationResult();
		if (1 == c) {
			result.setResult(false);
			result.setMessage("��ͬ�Ѵ���");
		}else{
			result.setResult(true);
			result.setMessage("��ʹ��");
		}
		return result;
	}
	
	/**
	 * ajax����ͬ�Ƿ����
	 * @param name
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping(value = "delete/contract")
	@ResponseBody
	public ValidationResult contracte(String name) throws ServletException, IOException{
		Contract u = new Contract();
		u.setName(name);
		int c = taxfreeContractService.NewContract(u.getName());
		ValidationResult result = new ValidationResult();
		if (1 == c) {
			result.setResult(true);
			result.setMessage("�ú�ͬ���Ա�ɾ��");
		}else{
			result.setResult(false);
			result.setMessage("��ͬ������");
		}
		return result;
	}
	
	/**
	 * ɾ����ͬ
	 * 
	 */
	@RequestMapping(value = "/delete")
	public String delete(String name){
		Contract u = new Contract();
		u.setName(name);
		taxfreeContractService.delete(u.getName());
		return "app/taxfree_contract";
	}
}
	