package com.geogym.user.dao;

import com.geogym.user.dto.User;

public interface UserInfoDao {

	User selectUserByUserno(int user_no);

	int selectCntTrainerByUserno(int user_no);

}
