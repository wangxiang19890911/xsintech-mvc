package com.xsintech.service;

import java.util.List;
import java.util.Map;

import com.xsintech.model.Contract;
import com.xsintech.model.User;

public interface TaxfreeContractService {
	public void inser(Contract u);
	public int NewContract(String name);
	public void delete(String name);
	public List<Contract> findfAll(Map map);
}
