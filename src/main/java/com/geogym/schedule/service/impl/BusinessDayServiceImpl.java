package com.geogym.schedule.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.schedule.dao.BusinessDayDao;
import com.geogym.schedule.dto.BusinessDay;
import com.geogym.schedule.service.BusinessDayService;

@Service
public class BusinessDayServiceImpl implements BusinessDayService {

	private static final Logger logger = LoggerFactory.getLogger(BusinessDayServiceImpl.class);
	
	@Autowired
	BusinessDayDao businessDayDao;

	@Override
	public boolean isWorkingDay(LocalDate date) throws NullPointerException {

//		System.out.println(date.getDayOfWeek().getValue());

		int chk = businessDayDao.selectCountBusinessDay(date);

		if (chk == 1) {
			return true;
		}

		return false;
	}

	@Override
	public void setWorkingTime(LocalDate date, BusinessDay workingTime) throws NullPointerException {

		if (!isWorkingDay(date)) {

			workingTime.setBusiness_day_date(date);

			businessDayDao.insertBusinessDay(workingTime);
		}

	}

	@Override
	public BusinessDay getWorkingTimeInfo(LocalDate date) throws NullPointerException {

		if (!isWorkingDay(date)) {
			return null;
		}

		return businessDayDao.selectBusinessDay(date);
	}

	@Override
	public List<BusinessDay> getWorkingTimeInfos(LocalDate date){
		
		List<BusinessDay> list = new ArrayList<BusinessDay>();
		
		HashMap<String, Object> map = new HashMap<>();

		map.put("start", LocalDate.of(date.getYear(), date.getMonth(), 1));
		map.put("end", LocalDateTime.of(date.getYear(), date.getMonth(), date.lengthOfMonth(), 23, 59));
		
		list = businessDayDao.selectBusinessDaysWholeMonth(map);
		
		return list;
	}

}
