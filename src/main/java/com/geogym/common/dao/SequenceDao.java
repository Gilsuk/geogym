package com.geogym.common.dao;

public interface SequenceDao {

	int selectCurVal(String tbname);

	int selectNextVal(String tbname);

}
