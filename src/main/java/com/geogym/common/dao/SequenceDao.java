package com.geogym.common.dao;

public interface SequenceDao {

	int selectCurVal(String tbname);

	void increaseCurVal(String tbname);

}
