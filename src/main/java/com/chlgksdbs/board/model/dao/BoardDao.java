package com.chlgksdbs.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chlgksdbs.board.model.dto.BoardDto;

@Repository
public class BoardDao {

	@Autowired
	private DBUtil util;

	public List<BoardDto> selectAll() throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardDto> result = new ArrayList<>();
		String sql = null;

		try {

			conn = util.getConnection();
			sql = " SELECT bno, btitle, bwriter, bwrite_date " + " FROM board_tb ";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDto board = new BoardDto();

				board.setBno(rs.getInt(1));
				board.setBtitle(rs.getString(2));
				board.setBwriter(rs.getString(3));
				board.setBwriteDate(rs.getString(4));

				result.add(board);
			}

		} finally {
			util.close(conn, pstmt, rs);
		}

		return result;
	}

	public BoardDto selectOne(int bno) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDto result = null;
		String sql = null;

		try {

			conn = util.getConnection();
			sql = " SELECT bno, btitle, bwriter, bcontent, bwrite_date " + " FROM board_tb " + " WHERE bno=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new BoardDto();

				result.setBno(rs.getInt(1));
				result.setBtitle(rs.getString(2));
				result.setBwriter(rs.getString(3));
				result.setBcontent(rs.getString(4));
				result.setBwriteDate(rs.getString(5));
			}

		} finally {
			util.close(conn, pstmt, rs);
		}

		return result;
	}

	public int insert(BoardDto board) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = null;

		try {

			conn = util.getConnection();
			sql = " INSERT INTO board_tb (btitle, bwriter, bcontent, bwrite_date) " + " VALUES(?, ?, ?, now()) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBwriter());
			pstmt.setString(3, board.getBcontent());

			result = pstmt.executeUpdate();

		} finally {
			util.close(conn, pstmt, rs);
		}

		return result;
	}

	public int update(BoardDto board) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = null;

		try {

			conn = util.getConnection();
			sql = " UPDATE board_tb "
					+ " SET btitle=?, bcontent=? "
					+ " WHERE bno=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setInt(3, board.getBno());

			result = pstmt.executeUpdate();

		} finally {
			util.close(conn, pstmt, rs);
		}

		return result;
	}

	public int delete(int bno) throws SQLException {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = null;

		try {

			conn = util.getConnection();
			sql = " DELETE FROM board_tb "
					+ " WHERE bno=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			result = pstmt.executeUpdate();

		} finally {
			util.close(conn, pstmt, rs);
		}

		return result;
	}
}
