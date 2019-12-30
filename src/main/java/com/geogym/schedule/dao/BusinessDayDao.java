package com.geogym.schedule.dao;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.geogym.schedule.dto.BusinessDay;

public interface BusinessDayDao {

	int selectCountBusinessDay(LocalDate date);

	void insertBusinessDay(BusinessDay workingTime);

	BusinessDay selectBusinessDay(LocalDate date);

	List<BusinessDay> selectBusinessDaysWholeMonth(HashMap<String, Object> map);

}
