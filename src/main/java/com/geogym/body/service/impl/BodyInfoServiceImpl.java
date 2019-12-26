package com.geogym.body.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.body.dao.face.BodyInfoDao;
import com.geogym.body.dto.BodyCommentary;
import com.geogym.body.dto.BodyInfo;
import com.geogym.body.service.face.BodyInfoService;
import com.geogym.common.enumeration.Table;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.common.service.SequenceService;
import com.geogym.schedule.dto.PeriodDate;
import com.geogym.schedule.exception.TooLongPeriodException;
import com.geogym.user.dto.User;

@Service
public class BodyInfoServiceImpl implements BodyInfoService{

	@Autowired SequenceService sequencService;
	@Autowired BodyInfoDao bodyInfoDao;
	
	@Override
	public BodyInfo getRecentBodyInfo(User user) {
		
		BodyInfo bodyInfo = bodyInfoDao.selectCurrentBodyInfo(user);
		
		return bodyInfo;
	}

	@Override
	public void setBodyInfo(BodyInfo bodyInfo) throws ParamIncorrectException {
		
		int nextVal = sequencService.getNextVal(Table.BODYINFO);
		bodyInfo.setBodyinfo_no(nextVal);
		
		bodyInfo.setBodyinfo_date(LocalDate.now());
		
		bodyInfoDao.insertBodyInfo(bodyInfo);
		
	}

	@Override
	public void deleteBodyInfo(BodyInfo bodyinfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BodyInfo> getBodyInfosByPeriod(User user, PeriodDate period) throws TooLongPeriodException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BodyInfo> getBodyInfosByWeek(User user) {
		
		List<BodyInfo> list = new ArrayList<BodyInfo>();
		
		for (int i = 0; i < 54; i++) {
			LocalDate localDate = LocalDate.now().minusWeeks(i);
			BodyInfo bodyInfo = getBodyInfosByWeek(user, localDate);
			if(bodyInfo!=null) 
			list.add(bodyInfo);
		}
		return list;
	}

	private BodyInfo getBodyInfosByWeek(User user, LocalDate localDate) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_no", user.getUser_no());
		map.put("date", localDate.toString());
		
		return bodyInfoDao.selectBodyInfoByWeek(map);
	}

	@Override
	public List<BodyInfo> getBodyInfosByMonth(User user, PeriodDate period) throws TooLongPeriodException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BodyCommentary getCommentary(BodyInfo bodyinfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBodyCommentary(BodyCommentary commentary) throws ParamIncorrectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBodyCommentary(BodyCommentary commentary) {
		// TODO Auto-generated method stub
		
	}
	
}
