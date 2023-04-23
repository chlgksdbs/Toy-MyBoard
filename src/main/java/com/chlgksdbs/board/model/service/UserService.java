package com.chlgksdbs.board.model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chlgksdbs.board.model.dao.UserDao;
import com.chlgksdbs.board.model.dto.UserDto;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	public UserDto login(String id, String pw) throws SQLException {
		return dao.select(id, pw);
	}
	
	public int regist(UserDto user) throws SQLException {
		return dao.insert(user);
	}
}
