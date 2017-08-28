package com.xsintech.dao;

import java.util.List;
import java.util.Map;

import com.xsintech.model.Contract;

public interface TaxfreeContractDao {
	public void inser(Contract c);
	public int NewContract(String name);
	public void delete(String name);
	public List<Contract> findfAll(Map map);
}
