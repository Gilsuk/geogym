package com.geogym.body.dao.face;

import java.util.Map;

import com.geogym.body.dto.BodyInfo;
import com.geogym.user.dto.User;

public interface BodyInfoDao {

	public void insertBodyInfo(BodyInfo bodyInfo);
	
	public BodyInfo selectCurrentBodyInfo(User user);
	
	public BodyInfo selectBodyInfoByWeek(Map map);
}
