package com.chlgksdbs.board.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.chlgksdbs.board.model.dto.UserDto;
import com.chlgksdbs.board.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		
		return "pages/auth/user/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		// Session에 있는 로그인 정보 삭제 (로그아웃)
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("/regist")
	public String regist() {
		
		return "pages/auth/user/regist";
	}
	
	@PostMapping("/login")
	public ModelAndView login(UserDto userDto, HttpSession session) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		// User 정보가 DB에 있는 지 체크
		UserDto loginInfo = userService.login(userDto.getUserId(), userDto.getUserPw());
		
		// User 정보가 DB에 없는 경우
		if (loginInfo == null) {
			mav.addObject("errorMsg", "회원 정보가 존재하지 않습니다.");
			mav.setViewName("pages/error/loginError");
			return mav;
		}
		// User 정보가 DB에 있는 경우
		else {
			session.setAttribute("loginInfo", loginInfo);
			mav.setViewName("redirect:/");
			return mav;
		}
	}
	
	@PostMapping("/regist")
	public ModelAndView regist(UserDto user) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		// 입력으로 들어온 user 정보를 DB에 insert하는 작업
		int val = userService.regist(user);
		
		// DB에 insert하는 작업이 실패한 경우 (user_id가 이미 존재하는 경우)
		if (val == -1) {
			mav.addObject("errorMsg", "동일한 아이디의 회원 정보가 이미 존재합니다.");
			mav.setViewName("pages/error/registError");
		} else {
			mav.addObject("successMsg", "회원 가입 성공!");
			mav.setViewName("pages/success/regist");
		}
		
		return mav;
	}
	
}
