package com.geogym.common.service;

import com.geogym.common.enumeration.Table;

public interface SequenceService {
	
	int getNextVal(Table table);
	int getCurVal(Table table);

}
