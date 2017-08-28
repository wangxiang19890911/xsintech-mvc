package com.xsintech.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xsintech.dao.TaxfreeContractDao;
import com.xsintech.dao.UserDao;
import com.xsintech.model.Contract;
import com.xsintech.model.User;
import com.xsintech.service.TaxfreeContractService;
import com.xsintech.service.UserService;

@Service("TaxfreeContractService")
public class TaxfreeContractImpl implements TaxfreeContractService {
	@Resource
	private TaxfreeContractDao taxfreeContractDao;

	public void inser(Contract c) {
		taxfreeContractDao.inser(c);
	}

	public int NewContract(String name) {
		return taxfreeContractDao.NewContract(name);
	}

	public void delete(String name) {
		taxfreeContractDao.delete(name);
	}

	public List<Contract> findfAll(Map map) {
		return taxfreeContractDao.findfAll(map);
	}

}
