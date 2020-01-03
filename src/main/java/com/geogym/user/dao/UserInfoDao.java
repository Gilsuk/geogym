package com.geogym.user.dao;

import com.geogym.user.dto.LoginInfo;
import com.geogym.user.dto.User;

public interface UserInfoDao {

	User selectUserByUserno(int user_no);

	int selectCntTrainerByUserno(int user_no);

	int selectCntManagerByUserno(int user_no);

	User selectUserByIdAndPw(LoginInfo info);

	void insertUser(User user);

	void insertIntoManager(int user_no);

	void deleteFromManager(int user_no);

	User selectUserByUserid(String user_id);

}
