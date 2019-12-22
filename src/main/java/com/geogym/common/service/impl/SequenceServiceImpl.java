package com.geogym.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.common.dao.SequenceDao;
import com.geogym.common.enumeration.Table;
import com.geogym.common.service.SequenceService;

@Service
public class SequenceServiceImpl implements SequenceService {
	
	@Autowired private SequenceDao dao;

	@Override
	public int getNextVal(Table table) {
		return dao.selectNextVal(table.toString());
	}

	@Override
	public int getCurVal(Table table) {
		return dao.selectCurVal(table.toString());
	}

}
