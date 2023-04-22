package com.chlgksdbs.board.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chlgksdbs.board.model.dto.BoardDto;
import com.chlgksdbs.board.model.dto.UserDto;
import com.chlgksdbs.board.model.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/list")
	public ModelAndView list(HttpSession session) throws SQLException {

		ModelAndView mav = new ModelAndView();

		// 로그인 정보 꺼내오기
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");

		// View Path 설정
		if (loginInfo == null) {
			mav.setViewName("pages/error/userError");
			return mav;
		}

		mav.setViewName("pages/board/list");

		// Service로 부터 DB board 리스트 뽑아서 Model에 담기
		mav.addObject("boardList", boardService.list());

		return mav;
	}

	@GetMapping("/write")
	public String write(HttpSession session) {

		// 로그인 정보 꺼내오기
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");

		// View Path 설정
		if (loginInfo == null) {
			return "pages/error/userError";
		}

		return "pages/board/write";
	}

	@GetMapping("/view")
	public String view(int bno, Model model, HttpSession session) throws SQLException {

		// 로그인 정보 꺼내오기
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");

		// View Path 설정
		if (loginInfo == null) {
			return "pages/error/userError";
		}

		// bno에 일치하는 board 정보를 Service로부터 가져오기
		BoardDto board = boardService.view(bno);

		// Service로부터 가져온 board 정보를 Model 객체에 담아 Forward로 전달
		model.addAttribute("board", board);

		return "pages/board/view";

	}

	@GetMapping("/modify")
	public ModelAndView modify(int bno, HttpSession session) throws SQLException {

		ModelAndView mav = new ModelAndView();

		// 로그인 정보 꺼내오기
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");

		// View Path 설정
		if (loginInfo == null) {
			mav.setViewName("pages/error/userError");
			return mav;
		}

		// 해당 bno의 board 정보 가져오기
		BoardDto board = boardService.view(bno);

		// 작성자와 로그인 정보가 일치하는 경우에 수정 페이지로 이동
		if (board.getBwriter().equals(loginInfo.getUserId())) {
			mav.addObject("board", board);
			mav.setViewName("pages/board/modify");
		} else {
			mav.setViewName("pages/error/crudError");
		}

		return mav;

	}

	@GetMapping("/delete")
	public String delete(int bno, HttpSession session) throws SQLException {

		// 로그인 정보 꺼내오기
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");

		// View Path 설정
		if (loginInfo == null) {
			return "pages/error/userError";
		}

		// 해당 bno의 board 정보 가져오기
		BoardDto board = boardService.view(bno);

		// 작성자와 로그인 정보가 일치하는 경우에 삭제 수행
		if (board.getBwriter().equals(loginInfo.getUserId())) {
			boardService.delete(bno);
			return "redirect:list";
		} else {
			return "pages/error/crudError";
		}
	}

	@PostMapping("/write")
	public String write(BoardDto board, HttpSession session) throws SQLException {

		// 로그인 정보 꺼내오기
		UserDto loginInfo = (UserDto) session.getAttribute("loginInfo");

		// 게시글의 작성자를 현재 로그인된 유저의 정보로 세팅
		board.setBwriter(loginInfo.getUserId());

		// 게시글 작성 DB 작업
		boardService.write(board);

		return "redirect:list";
	}

	@PostMapping("/modify")
	public String modify(BoardDto board) throws SQLException {

		// 게시글 수정 DB 작업
		boardService.modify(board);
		
		return "redirect:view?bno=" + board.getBno();
	}

}
