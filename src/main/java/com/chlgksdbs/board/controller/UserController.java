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
	
	@PostMapping("/login")
	public ModelAndView login(UserDto userDto, HttpSession session) throws SQLException {
		
		ModelAndView mav = new ModelAndView();
		
		// User 정보가 DB에 있는 지 체크
		UserDto loginInfo = userService.login(userDto.getUserId(), userDto.getUserPw());
		
		// User 정보가 DB에 없는 경우
		if (loginInfo == null) {
			mav.addObject("errorMsg", "회원 정보가 존재하지 않습니다.");
			mav.setViewName("pages/error/userError");
			return mav;
		}
		// User 정보가 DB에 있는 경우
		else {
			session.setAttribute("loginInfo", loginInfo);
			mav.setViewName("redirect:/");
			return mav;
		}
	}
	
}
