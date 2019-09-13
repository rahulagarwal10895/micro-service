package com.mettalica.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mettalica.dao.MarketDataDao;
import com.mettalica.exception.DataNotFoundException;
import com.mettalica.model.entity.MarketData;

@Service
public class MarketService {

	@Autowired
	MarketDataDao dao;

	public MarketData findByCommodity(String commodityCode) throws DataNotFoundException {

		MarketData data = dao.findByCommodity(commodityCode);
		if (null == data) {
			throw new DataNotFoundException("Data Not Exists");
		}

		return data;
	}

	

}
