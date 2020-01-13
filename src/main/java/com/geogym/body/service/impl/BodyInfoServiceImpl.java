package com.geogym.body.service.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geogym.attachment.dto.Attachment;
import com.geogym.body.dao.face.BodyInfoDao;
import com.geogym.body.dto.BodyComment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.body.service.face.BodyInfoService;
import com.geogym.common.enumeration.Table;
import com.geogym.common.exception.ParamIncorrectException;
import com.geogym.common.service.SequenceService;
import com.geogym.trainer.dto.Trainer;
import com.geogym.user.dto.User;
import com.google.gson.Gson;

@Service
public class BodyInfoServiceImpl implements BodyInfoService{

	@Autowired SequenceService sequenceService;
	@Autowired BodyInfoDao bodyInfoDao;
	
	@Override
	public BodyInfo getRecentBodyInfo(User user) {
		
		BodyInfo bodyInfo = bodyInfoDao.selectCurrentBodyInfo(user);
		
		return bodyInfo;
	}

	@Override
	public void setBodyInfo(BodyInfo bodyInfo) throws ParamIncorrectException {
		
		int nextVal = sequenceService.getNextVal(Table.BODYINFO);
		bodyInfo.setBodyinfo_no(nextVal);
		bodyInfo.setBodyinfo_date(LocalDate.now());
		
		bodyInfoDao.insertBodyInfo(bodyInfo);
		
	}

	@Override
	public void deleteBodyInfo(BodyInfo bodyinfo) {
		
		bodyInfoDao.deleteBodyInfo(bodyinfo);
		
	}

	@Override
	public List<BodyInfo> getWeightByWeek(User user) {
		List<BodyInfo> list = new ArrayList<BodyInfo>();
		
		for (int i = 0; i < 54; i++) {
			LocalDate localDate = LocalDate.now().minusWeeks(i);
			BodyInfo bodyInfo = getBodyInfosByWeek(user, localDate);
			if(bodyInfo!=null) 
			list.add(bodyInfo);
		}
		
		Gson gson = new Gson();
		
//		차트에 데이터 넣기 (2차원 배열 사용)
		ArrayList arr = new ArrayList();
		ArrayList tmp = new ArrayList();

		for(BodyInfo b : list) {
			ArrayList a = new ArrayList();
			
			a.add("new Date(" + b.getBodyinfo_date().getYear()
					+ "," + b.getBodyinfo_date().getMonthValue()
					+ "," + b.getBodyinfo_date().getDayOfMonth()
					+ ")");
			a.add(b.getBodyinfo_weight());
			
			arr.add(a);
		}
		return arr;
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
		
		Gson gson = new Gson();
		
//		차트에 데이터 넣기 (2차원 배열 사용)
		ArrayList arr = new ArrayList();
		ArrayList tmp = new ArrayList();

		for(BodyInfo b : list) {
			ArrayList a = new ArrayList();
			
			a.add("new Date(" + b.getBodyinfo_date().getYear()
					+ "," + b.getBodyinfo_date().getMonthValue()
					+ "," + b.getBodyinfo_date().getDayOfMonth()
					+ ")");
			a.add(b.getBodyinfo_muscle());
			a.add(b.getBodyinfo_fat());
			
			arr.add(a);
		}
		return arr;
	}

	private BodyInfo getBodyInfosByWeek(User user, LocalDate localDate) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_no", user.getUser_no());
		map.put("date", localDate.toString());
		
		return bodyInfoDao.selectBodyInfoByWeek(map);
	}
	
	@Override
	public List<BodyInfo> getWeightByMonth(User user) {
		List<BodyInfo> list = new ArrayList<BodyInfo>();
		
		for (int i = 0; i < 54; i++) {
			LocalDate localDate = LocalDate.now().minusMonths(i);
			BodyInfo bodyInfo = getBodyInfosByMonth(user, localDate);
			if(bodyInfo!=null) 
			list.add(bodyInfo);
		}
		
		Gson gson = new Gson();
		
//		차트에 데이터 넣기 (2차원 배열 사용)
		ArrayList arr = new ArrayList();
		ArrayList tmp = new ArrayList();

		for(BodyInfo b : list) {
			ArrayList a = new ArrayList();
			
			a.add("new Date(" + b.getBodyinfo_date().getYear()
					+ "," + b.getBodyinfo_date().getMonthValue()
					+ "," + b.getBodyinfo_date().getDayOfMonth()
					+ ")");
			a.add(b.getBodyinfo_weight());

			
			arr.add(a);
		}
		return arr;
	}

	@Override
	public List<BodyInfo> getBodyInfosByMonth(User user) {
		
		List<BodyInfo> list = new ArrayList<BodyInfo>();
		
		for (int i = 0; i < 54; i++) {
			LocalDate localDate = LocalDate.now().minusMonths(i);
			BodyInfo bodyInfo = getBodyInfosByMonth(user, localDate);
			if(bodyInfo!=null) 
			list.add(bodyInfo);
		}
		
		Gson gson = new Gson();
		
//		차트에 데이터 넣기 (2차원 배열 사용)
		ArrayList arr = new ArrayList();
		ArrayList tmp = new ArrayList();

		for(BodyInfo b : list) {
			ArrayList a = new ArrayList();
			
			a.add("new Date(" + b.getBodyinfo_date().getYear()
					+ "," + b.getBodyinfo_date().getMonthValue()
					+ "," + b.getBodyinfo_date().getDayOfMonth()
					+ ")");
			a.add(b.getBodyinfo_muscle());
			a.add(b.getBodyinfo_fat());
			
			arr.add(a);
		}
		return arr;
	}
	
	private BodyInfo getBodyInfosByMonth(User user, LocalDate localDate) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user_no", user.getUser_no());
		map.put("date", localDate.toString());
		
		return bodyInfoDao.selectBodyInfoByMonth(map);
	}

	@Override
	public BodyComment getCommentary(User user) {

		return bodyInfoDao.selectBodyCommentary(user);
	}

	@Override
	public void setBodyCommentary(BodyComment commentary, Trainer trainer, BodyInfo bodyinfo) throws ParamIncorrectException {
		
		System.out.println("trainer : " + trainer.getTrainer_no()); 
//		int bodyInfo_nextVal = sequenceService.getNextVal(Table.BODYINFO);
		int bodyComment_nextVal = sequenceService.getNextVal(Table.BODY_COMMENT);
		int Bodyinfo_no = bodyInfoDao.selectBodyinfoNo();
		
		commentary.setBodyinfo_no(Bodyinfo_no);
		commentary.setBody_comment_no(bodyComment_nextVal);
		commentary.setTrainer_no(trainer.getTrainer_no());
		commentary.setBody_comment_date(LocalDateTime.now());	
		
		bodyInfoDao.insertBodyCommentary(commentary);
	}

	@Override
	public void deleteBodyCommentary(BodyInfo bodyinfo) {
		bodyInfoDao.deleteBodyCommentary(bodyinfo);

		
	}

	@Override
	public List<BodyInfo> getHeightByWeek(User user) {
		List<BodyInfo> list = new ArrayList<BodyInfo>();
		
		for (int i = 0; i < 54; i++) {
			LocalDate localDate = LocalDate.now().minusWeeks(i);
			BodyInfo bodyInfo = getBodyInfosByWeek(user, localDate);
			if(bodyInfo!=null) 
			list.add(bodyInfo);
		}
		
		Gson gson = new Gson();
		
//		차트에 데이터 넣기 (2차원 배열 사용)
		ArrayList arr = new ArrayList();
		ArrayList tmp = new ArrayList();

		for(BodyInfo b : list) {
			ArrayList a = new ArrayList();
			
			a.add("new Date(" + b.getBodyinfo_date().getYear()
					+ "," + b.getBodyinfo_date().getMonthValue()
					+ "," + b.getBodyinfo_date().getDayOfMonth()
					+ ")");
			a.add(b.getBodyinfo_height());
			
			arr.add(a);
		}
		return arr;
	}

	@Override
	public List<BodyInfo> getHeightByMonth(User user) {
		List<BodyInfo> list = new ArrayList<BodyInfo>();
		
		for (int i = 0; i < 54; i++) {
			LocalDate localDate = LocalDate.now().minusMonths(i);
			BodyInfo bodyInfo = getBodyInfosByMonth(user, localDate);
			if(bodyInfo!=null) 
			list.add(bodyInfo);
		}
		
		Gson gson = new Gson();
		
//		차트에 데이터 넣기 (2차원 배열 사용)
		ArrayList arr = new ArrayList();
		ArrayList tmp = new ArrayList();

		for(BodyInfo b : list) {
			ArrayList a = new ArrayList();
			
			a.add("new Date(" + b.getBodyinfo_date().getYear()
					+ "," + b.getBodyinfo_date().getMonthValue()
					+ "," + b.getBodyinfo_date().getDayOfMonth()
					+ ")");
			a.add(b.getBodyinfo_height());

			
			arr.add(a);
		}
		return arr;
	}

	@Override
	public List<Attachment> getProfile(User loggedInUser) {
		return bodyInfoDao.selectProfileByUserNo(loggedInUser);
	}

	@Override
	public int getCountBodyinfo(HashMap<String, Object> list) {
		return bodyInfoDao.selectCountBodyinfoByDate(list);
	}
	
	
	
}
