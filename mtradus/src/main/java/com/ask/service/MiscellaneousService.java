/**
 * 
 */
package com.ask.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ask.dao.MiscellaneousDAOImpl;
import com.ask.pojo.MiscellaneousPojo;
import com.ask.util.CommonObjectMethods;

/**
 * @author ASK
 *
 */
@Service
public class MiscellaneousService {

	@Autowired
	MiscellaneousDAOImpl miscellaneousDAOImpl;

	public MiscellaneousDAOImpl getMiscellaneousDAOImpl() {
		return miscellaneousDAOImpl;
	}

	public void setMiscellaneousDAOImpl(MiscellaneousDAOImpl miscellaneousDAOImpl) {
		this.miscellaneousDAOImpl = miscellaneousDAOImpl;
	}
	
	public HashMap<String,String> saveMiscellaneousData(MiscellaneousPojo pojo){
		String response = miscellaneousDAOImpl.saveMiscellaneousData(pojo);
		return CommonObjectMethods.buildOutObject(response);
	}
}
