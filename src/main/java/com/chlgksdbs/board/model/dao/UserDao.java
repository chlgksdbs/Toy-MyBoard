package com.chlgksdbs.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chlgksdbs.board.model.dto.UserDto;

@Repository
public class UserDao {

	@Autowired
	private DBUtil util;

	public UserDto select(String id, String pw) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDto result = null;
		String sql = null;

		try {

			conn = util.getConnection();
			sql = " SELECT user_id, user_pw, user_name " + " FROM user_tb " + " WHERE user_id=? AND user_pw=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new UserDto();

				result.setUserId(rs.getString(1));
				result.setUserPw(rs.getString(2));
				result.setUserName(rs.getString(3));
			}

		} finally {
			util.close(conn, pstmt, rs);
		}

		return result;
	}

	public int insert(UserDto user) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = null;

		try {

			conn = util.getConnection();
			sql = " INSERT INTO user_tb (user_id, user_pw, user_name) " + " VALUES(?, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserPw());
			pstmt.setString(3, user.getUserName());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			util.close(conn, pstmt, rs);
		}

		return result;
	}
}
