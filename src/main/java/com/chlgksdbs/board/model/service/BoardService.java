package com.chlgksdbs.board.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chlgksdbs.board.model.dao.BoardDao;
import com.chlgksdbs.board.model.dto.BoardDto;

@Service
public class BoardService {

	@Autowired
	private BoardDao dao;
	
	public List<BoardDto> list() throws SQLException {
		return dao.selectAll();
	}
	
	public BoardDto view(int bno) throws SQLException {
		return dao.selectOne(bno);
	}
	
	public int write(BoardDto board) throws SQLException {
		return dao.insert(board);
	}
	
	public int modify(BoardDto board) throws SQLException {
		return dao.update(board);
	}
	
	public int delete(int bno) throws SQLException {
		return dao.delete(bno);
	}
}
