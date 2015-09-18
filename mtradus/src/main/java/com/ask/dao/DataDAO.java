package com.ask.dao;

import java.util.List;

import com.ask.dbpojo.Area;
import com.ask.dbpojo.District;


public interface DataDAO {
	public List<District> getAllDistrict(String id);
	public Area getAreaByName(String areaName);
}
