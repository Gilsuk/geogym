package com.geogym.body.dao.face;

import java.util.Map;

import com.geogym.body.dto.BodyComment;
import com.geogym.body.dto.BodyInfo;
import com.geogym.user.dto.User;

public interface BodyInfoDao {

	public void insertBodyInfo(BodyInfo bodyInfo);
	
	public BodyInfo selectCurrentBodyInfo(User user);
	
	public BodyInfo selectBodyInfoByWeek(Map map);
	
	public BodyInfo selectBodyInfoByMonth(Map map);
	
	public void insertBodyCommentary(BodyComment commentary);
	
	public BodyComment selectBodyCommentary(User user);
	
	public void deleteBodyInfo(BodyInfo bodyinfo);
	
	public void deleteBodyCommentary(BodyInfo bodyinfo);
}
