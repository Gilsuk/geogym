package com.geogym.common.service.impl;

import org.springframework.stereotype.Service;

import com.geogym.common.enumeration.Table;
import com.geogym.common.service.SequenceService;

@Service
public class SequenceServiceImpl implements SequenceService {

	@Override
	public int getNextVal(Table table) {
		return 0;
	}

	@Override
	public int getCurVal(Table table) {
		return 0;
	}

}
